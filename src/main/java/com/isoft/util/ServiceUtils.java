package com.isoft.util;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hejian on 14-5-3.
 */
public class ServiceUtils {

	/**
	 * 将明文密码经过md5 和 base64加密
	 * @param message 原始的明文密码
	 * @return 返回加密后的密码
	 */
	public static String MD5(String message){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] md5 = md.digest(message.getBytes());

			return Base64.encodeBase64String(md5);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
