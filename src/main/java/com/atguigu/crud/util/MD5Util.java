package com.atguigu.crud.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密算法
 * pkd
 */
public class MD5Util {

	/**
	 * MD5值
	 * 如果需要把转换后的密码保存到数据库中，需要使用的类型为：char(32)
	 */
	public static String encryptMD5(String inStr) {

		MessageDigest md5 = null;
		try {
			// 获取MessageDigest对象，该对象完成加密
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return null;
		}
		// 把要加密的信息转换成字节数组，再使用转换后的字节数组初始化MessgeDigest对象
		md5.update(inStr.getBytes());
		// 调用digest方法进行加密，返回byte数组
		byte[] hash = md5.digest();
		StringBuffer hexValue = new StringBuffer();
		int i = 0;
		for (int offset = 0; offset < hash.length; offset++) {
			i = hash[offset];
			if (i < 0) {
				i += 256;
			}
			if (i < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(i));
		}
		// 把byte数组转换成字符串，然后就可以使用加密后的字符串了
		return hexValue.toString();
	}



	// 可逆的MD5加密
	public static void main(String[] args) {
		String s = new String("123456");
		System.out.println("加密前：" + s);

		// 生成MD5值
		String encryptResult = encryptMD5(s);
		System.out.println("MD5后：" + encryptResult);


	}

}
