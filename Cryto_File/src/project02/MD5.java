package project02;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public byte[] Encrypt(String key, byte[] bit) {
		byte[] encrypted = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(bit); 
			encrypted= md.digest();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return encrypted;

	}
}
