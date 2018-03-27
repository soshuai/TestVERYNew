package com.example.veryw.testveryssssss.ftp.com.util;

public class IpUtil
{
    
    /**
     * ��127.0.0.1��ʽ��IP��ַת����ʮ��������������û�н����κδ����� ͨ������λ������<<����ÿһ�ε����ּ�Ȩ����һ�ε�ȨΪ2��24�η����ڶ��ε�ȨΪ2��16�η��������ε�ȨΪ2��8�η������һ�ε�ȨΪ1
     */
    public static long ipToLong(String ipaddress)
    {
        long[] ip = new long[4];
        // ���ҵ�IP��ַ�ַ�����.��λ��
        int position1 = ipaddress.indexOf(".");
        int position2 = ipaddress.indexOf(".", position1 + 1);
        int position3 = ipaddress.indexOf(".", position2 + 1);
        // ��ÿ��.֮����ַ���ת��������
        ip[0] = Long.parseLong(ipaddress.substring(0, position1));
        ip[1] = Long.parseLong(ipaddress.substring(position1 + 1, position2));
        ip[2] = Long.parseLong(ipaddress.substring(position2 + 1, position3));
        ip[3] = Long.parseLong(ipaddress.substring(position3 + 1));
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }
    
    /**
     * ��ʮ����������ʽת����127.0.0.1��ʽ��ip��ַ ������ֵ��������λ������>>>��������24λ������ʱ��λ��0���õ������ּ�Ϊ��һ��IP��
     * ͨ�����������&��������ֵ�ĸ�8λ��Ϊ0��������16λ���õ������ּ�Ϊ�ڶ���IP�� ͨ���������������ֵ�ĸ�16λ��Ϊ0��������8λ���õ������ּ�Ϊ������IP�� ͨ���������������ֵ�ĸ�24λ��Ϊ0���õ������ּ�Ϊ���Ķ�IP��
     */
    public static String longToIP(long ipaddress)
    {
        StringBuffer sb = new StringBuffer("");
        // ֱ������24λ
        sb.append(String.valueOf((ipaddress >>> 24)));
        sb.append(".");
        // ����8λ��0��Ȼ������16λ
        sb.append(String.valueOf((ipaddress & 0x00FFFFFF) >>> 16));
        sb.append(".");
        // ����16λ��0��Ȼ������8λ
        sb.append(String.valueOf((ipaddress & 0x0000FFFF) >>> 8));
        sb.append(".");
        // ����24λ��0
        sb.append(String.valueOf((ipaddress & 0x000000FF)));
        return sb.toString();
    }
}
