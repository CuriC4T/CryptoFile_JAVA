package project02;

import java.io.File;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DES {

	

	public byte[] Encrypt(String key, byte[] bit) {
		byte[] encrypted = null;
		byte[] keybit = key.getBytes();
		System.out.println(keybit.length);
		try {
			Cipher	c = Cipher.getInstance("DES");
			DESKeySpec desKey = new DESKeySpec(key.getBytes());
			SecretKeyFactory	keyFactory = SecretKeyFactory.getInstance("DES");
			Key secretkey = keyFactory.generateSecret(desKey);
			c.init(Cipher.ENCRYPT_MODE, secretkey);
			encrypted = c.doFinal(bit);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
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
		try {
			Cipher c = Cipher.getInstance("DES");
			DESKeySpec desKey = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			Key secretkey = keyFactory.generateSecret(desKey);
			c.init(Cipher.DECRYPT_MODE, secretkey);
			decrypted = c.doFinal(bit);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
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
