package project02;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class TwoFish {
	public byte[] Encrypt(String key, byte[] bit) {
		byte[] encrypted = null;
		SecureRandom sr = new SecureRandom(key.getBytes());
		KeyGenerator kg;
		try {
			kg = KeyGenerator.getInstance("twofish");
			kg.init(sr);
			SecretKey sk = kg.generateKey();
			Cipher c = Cipher.getInstance("twofish");
			c.init(Cipher.ENCRYPT_MODE, sk);
			encrypted = c.doFinal(bit);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		SecureRandom sr = new SecureRandom(key.getBytes());
		KeyGenerator kg;
		try {
			kg = KeyGenerator.getInstance("twofish");
			kg.init(sr);
			SecretKey sk = kg.generateKey();
			Cipher c = Cipher.getInstance("twofish");
			c.init(Cipher.DECRYPT_MODE, sk);
			decrypted = c.doFinal(bit);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
