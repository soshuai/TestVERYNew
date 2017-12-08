package com.example.veryw.testveryssssss;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.veryw.testveryssssss.base.BaseActivity;
import com.example.veryw.testveryssssss.util.ImageUtils;
import com.example.veryw.testveryssssss.util.IoUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhotoActivity extends BaseActivity implements View.OnClickListener {
    private final static int CROP = 200;
    private final static String FILE_SAVEPATH = Environment.getExternalStorageDirectory().getAbsolutePath()
            + "/whbApp/Portrait/";
    private Uri origUri;
    private Uri cropUri;
    private File protraitFile;
    private String protraitPath;
    private String protraitUrl;
    private Button photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        initView();
    }

    /**
     * 更换头像操作选择
     *
     * @param items
     */
    public void imageChooseItem(CharSequence[] items) {
        AlertDialog imageDialog = new AlertDialog.Builder(this).setTitle("上传图片").setIcon(android.R.drawable.btn_star)
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        // 相册选图
                        if (item == 0) {
                            startImagePick();
                        }
                        // 手机拍照
                        else if (item == 1) {
                            startActionCamera();
                        }
                    }
                }).create();

        imageDialog.show();
    }

    /**
     * 选择图片裁剪
     */
    private void startImagePick() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "选择图片"), ImageUtils.REQUEST_CODE_GETIMAGE_BYCROP);
    }

    /**
     * 相机拍照
     */
    private void startActionCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, this.getCameraTempFile());
        startActivityForResult(intent, ImageUtils.REQUEST_CODE_GETIMAGE_BYCAMERA);
    }

    // 裁剪头像的绝对路径
    private Uri getUploadTempFile(Uri uri) {
        String storageState = Environment.getExternalStorageState();
        if (storageState.equals(Environment.MEDIA_MOUNTED)) {
            File savedir = new File(FILE_SAVEPATH);
            if (!savedir.exists()) {
                savedir.mkdirs();
            }
        } else {
            Toast.makeText(PhotoActivity.this, "无法保存上传的头像，请检查SD卡是否挂载", Toast.LENGTH_SHORT).show();
            return null;
        }
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String thePath = ImageUtils.getAbsolutePathFromNoStandardUri(uri);

        // 如果是标准Uri
        if (TextUtils.isEmpty(thePath)) {
            thePath = ImageUtils.getAbsoluteImagePath(PhotoActivity.this, uri);
        }
        String ext = IoUtils.getFileFormat(thePath);
        ext = TextUtils.isEmpty(ext) ? "jpg" : ext;
        // 照片命名
        String cropFileName = "joyenglish_crop_" + timeStamp + "." + ext;
        // 裁剪头像的绝对路径
        protraitPath = FILE_SAVEPATH + cropFileName;
        protraitFile = new File(protraitPath);

        cropUri = Uri.fromFile(protraitFile);
        this.cropUri=this.cropUri;
        return this.cropUri;
    }

    // 拍照保存的绝对路径
    private Uri getCameraTempFile() {
        String storageState = Environment.getExternalStorageState();
        if (storageState.equals(Environment.MEDIA_MOUNTED)) {
            File savedir = new File(FILE_SAVEPATH);
            if (!savedir.exists()) {
                savedir.mkdirs();
            }
        } else {
            Toast.makeText(PhotoActivity.this, "无法保存上传的头像，请检查SD卡是否挂载", Toast.LENGTH_SHORT).show();
            return null;
        }
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        // 照片命名
        String cropFileName = "joyenglish_camera_" + timeStamp + ".jpg";
        // 裁剪头像的绝对路径
        protraitPath = FILE_SAVEPATH + cropFileName;
        protraitFile = new File(protraitPath);
        cropUri = Uri.fromFile(protraitFile);
        this.origUri = this.cropUri;
        return this.cropUri;
    }

    /**
     * 裁剪图片
     *
     * @param data 原始图片
     */
    private void startActionCrop(Uri data) {
        Log.i("wangs", "=========================");
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(data, "image/*");
        intent.putExtra("output", this.getUploadTempFile(data));
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);// 裁剪框比例
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", CROP);// 输出图片大小
        intent.putExtra("outputY", CROP);
        intent.putExtra("scale", true);// 去黑边
        intent.putExtra("scaleUpIfNeeded", true);// 去黑边
        startActivityForResult(intent, ImageUtils.REQUEST_CODE_GETIMAGE_BYSDCARD);
    }


    /**
     * 上传新照片
     */
    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        Log.i("wangs","=========================requestCode="+requestCode+",resultCode="+resultCode+",data="+data);
        if (resultCode != RESULT_OK)
            return;

        switch (requestCode) {
            case ImageUtils.REQUEST_CODE_GETIMAGE_BYCAMERA:
                startActionCrop(origUri);// 拍照后裁剪
                Log.i("sss","拍照=="+origUri);
                break;
            case ImageUtils.REQUEST_CODE_GETIMAGE_BYCROP:
                startActionCrop(data.getData());// 选图后裁剪
                Log.i("sss","照片=="+data.getData());
                break;
            case ImageUtils.REQUEST_CODE_GETIMAGE_BYSDCARD:
                // 照片上传到七牛
                Bundle bundle = new Bundle();
                bundle.putInt("TaskType", 1);
//                new UserInfoTask(this, this).exe(bundle);
                break;
        }
    }


    private void initView() {
        photo = (Button) findViewById(R.id.photo);
        photo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.photo:
                CharSequence[] items = {getString(R.string.img_from_album), getString(R.string.img_from_camera)};
                imageChooseItem(items);
                break;
            default:
                break;
        }
    }
}
