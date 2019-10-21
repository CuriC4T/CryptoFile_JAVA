package project02;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class AES {

	public AES() throws UnsupportedEncodingException {

	}

	public byte[] Encrypt(String key, byte[] bit)
			throws NoSuchAlgorithmException, GeneralSecurityException, UnsupportedEncodingException {
		key = key.substring(0, 16);
		String iv = key.substring(0, 16);

		Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv.getBytes()));
		byte[] encrypted = c.doFinal(bit);
		return encrypted;
	}

	public byte[] Decrypt(String key, byte[] bit)
			throws NoSuchAlgorithmException, GeneralSecurityException, UnsupportedEncodingException {
		key = key.substring(0, 16);

		String iv = key.substring(0, 16);
		Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv.getBytes()));
		byte[] decrypted = c.doFinal(bit);
		return decrypted;
	}
}
