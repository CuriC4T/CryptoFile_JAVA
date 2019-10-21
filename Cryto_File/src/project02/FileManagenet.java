package project02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class FileManagenet {

	public FileManagenet() {

	}

	public byte[] loadFile(File filePath) {
		FileInputStream inputStream;
		byte[] inputBytes = null;
		try {
			inputStream = new FileInputStream(filePath);
			inputBytes = new byte[(int) filePath.length()];
			inputStream.read(inputBytes);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputBytes;

	}

	public byte[] saveFile(File outputFile, byte[] outputBytes) {
		try {
			FileOutputStream outputStream = new FileOutputStream(outputFile);
			outputStream.write(outputBytes);
			outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return outputBytes;
	}

}
