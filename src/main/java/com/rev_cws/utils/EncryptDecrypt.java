package com.rev_cws.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecrypt {

	public static String encrypt(String strClearText) throws Exception {
		String strData = "";
		String encryptKey = System.getenv("postgreSQLencryptKey");
		// System.out.println("encryptKey = " + encryptKey);

		try {
			SecretKeySpec skeyspec = new SecretKeySpec(encryptKey.getBytes(), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted = cipher.doFinal(strClearText.getBytes());
			strData = new String(encrypted);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}

	public static String decrypt(String strEncrypted) throws Exception {
		String strData = "";
		String decryptKey = System.getenv("postgreSQLencryptKey");

		try {
			SecretKeySpec skeyspec = new SecretKeySpec(decryptKey.getBytes(), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, skeyspec);
			byte[] decrypted = cipher.doFinal(strEncrypted.getBytes());
			strData = new String(decrypted);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}
}