/**
 * 
 */
package cn.pms.ssm.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/** 
 * <p>Title: MD5Encode</p> 
 * <p>Description:TODO </p> 
 * <p>Company: uestc_xr</p> 
 * @author  Xiaozhe 
 * @date 创建时间：2017年8月10日 上午9:20:38 
 * @version 1.0 
*/
public class MD5EncodeUtil { 
	
	public static String md5Encode(String str) {
		
		String result = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64 = new BASE64Encoder();
			
			result = base64.encode(md5.digest(str.getBytes("utf-8")));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

//	public static void main(String[] args) {
//		System.out.println(md5Encode("201621220160"));
//	}
}
