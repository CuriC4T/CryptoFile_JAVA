package project01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManagenet {

	public byte[] readAllBytes(String filePath) {
		byte[] temp = null;
		String content = "";
		try {
			temp = Files.readAllBytes(Paths.get(filePath));
			System.out.println(temp.length);
			// content = new String ( temp );
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}

	public void saveFile(String filePath, byte[] temp) {
		
		
		try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
			fileOutputStream.write(temp);
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
