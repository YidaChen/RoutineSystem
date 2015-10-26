package com.javasj.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 
* @ClassName: MD5Util 
* @Description: TODO(MD5加密算法) 
* @author 王小圈 
* @date 2015年10月26日 下午6:10:13 
*
 */
public class MD5Util {
    public static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            // 32位加密
            return buf.toString();
            // 16位的加密
            // return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
