package com.example.veryw.testveryssssss.ftp.test.bussiness;


import com.example.veryw.testveryssssss.ftp.bussiness.BussinessUtil;
import com.example.veryw.testveryssssss.ftp.com.util.ConfigConst;
import com.example.veryw.testveryssssss.ftp.com.util.IpUtil;
import com.example.veryw.testveryssssss.ftp.run.GetWhiteListtask;

import java.util.logging.Logger;

public class BussinessTest {
	
	private static final Logger logger = Logger.getLogger(String.valueOf(GetWhiteListtask.class));

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		BussinessUtil bussinessUtil = BussinessUtil.getInstance();
		ConfigConst.getConfigConst();
		logger.info("程序开始运行");
		Thread r = new Thread(new GetWhiteListtask(bussinessUtil));
		r.start();

		boolean ipCheckFlag = bussinessUtil.checkIPwhitelist(IpUtil.ipToLong("111.62.90.254"));
		if(ipCheckFlag){
			System.out.println("111.62.90.254在其中");
		}else{
			System.out.println("111.62.90.254不在其中");
		}

	}

}
