package project01;
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
	private String iv;
	private Key keySpec;

	/**
	 * 16�ڸ��� Ű���� �Է��Ͽ� ��ü�� �����Ѵ�.
	 * 
	 * @param key
	 *            ��/��ȣȭ�� ���� Ű��
	 * @throws UnsupportedEncodingException
	 *             Ű���� ���̰� 16������ ��� �߻�
	 */
	final static String key = "asf4s84a4sda4s5d";

	public AES() throws UnsupportedEncodingException {
		this.iv = key.substring(0, 16);
		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length) {
			len = keyBytes.length;
		}
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

		this.keySpec = keySpec;
	}

	/**
	 * AES256 ���� ��ȣȭ �Ѵ�.
	 * 
	 * @param str
	 *            ��ȣȭ�� ���ڿ�
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws GeneralSecurityException
	 * @throws UnsupportedEncodingException
	 */
	public byte[] encrypt(byte[] bit) throws NoSuchAlgorithmException,
			GeneralSecurityException, UnsupportedEncodingException {
		String str= new String(bit, StandardCharsets.UTF_8);
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
		byte[] encrypted = c.doFinal(str.getBytes(StandardCharsets.UTF_8));
		//String enStr = new String(Base64.encodeBase64(encrypted));
		return encrypted;
	}
	/**
	 * AES256���� ��ȣȭ�� txt �� ��ȣȭ�Ѵ�.
	 * 
	 * @param str
	 *            ��ȣȭ�� ���ڿ�
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws GeneralSecurityException
	 * @throws UnsupportedEncodingException
	 */
	public byte[] decrypt(byte[] bit) throws NoSuchAlgorithmException,
			GeneralSecurityException, UnsupportedEncodingException {
		String str= new String(bit, StandardCharsets.UTF_8);
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
		byte[] decrypted = Base64.decodeBase64(str.getBytes(StandardCharsets.UTF_8));
		return decrypted;
	}
}
