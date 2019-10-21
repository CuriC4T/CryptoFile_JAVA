package project02;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class BlowFish {

	public byte[] Encrypt(String key, byte[] bit) {
		byte[] encrypted = null;
		byte[] keyData = key.getBytes();
		SecretKeySpec KS = new SecretKeySpec(keyData, "Blowfish");
		try {
			Cipher c = Cipher.getInstance("Blowfish");
			c.init(Cipher.ENCRYPT_MODE, KS);
			encrypted = c.doFinal(bit);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return encrypted;
	}

	public byte[] Decrypt(String key, byte[] bit) {
		byte[] decrypted = null;
		byte[] keyData = key.getBytes();
		SecretKeySpec KS = new SecretKeySpec(keyData, "Blowfish");
		try {
			Cipher c = Cipher.getInstance("Blowfish");
			c.init(Cipher.DECRYPT_MODE, KS);
			decrypted = c.doFinal(bit);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return decrypted;

	}
}
