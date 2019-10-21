package project02;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {
	public byte[] sha256(byte[] msg) throws NoSuchAlgorithmException {
	    MessageDigest md = MessageDigest.getInstance("SHA-256");
	    md.update(msg);
	    
	    return md.digest();
	}
	
	
}
