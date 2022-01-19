package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;

public class FileCopy {
	FileInputStream fis;
	FileOutputStream fos;
	
	public void copyFileSystem(String src, String dest) {
		File source = new File(src);
		File destination = new File(dest);
		
		destination.mkdirs();
		copy(source, destination);
	}
	
	public void moveFileSystem(String src, String dest) {
		File source = new File(src);
		File destination = new File(dest);
		
		destination.mkdirs();
		copy(source, destination);
		
		if(source.delete()) {
			System.out.println("���� �̵��� �Ϸ�Ǿ����ϴ�.");
		} else {
			System.out.println("���� �̵��� ���еǾ����ϴ�.");
		}
	}
	
	public void copy(File src, File dest) {
		dest.mkdir();
		
		if(src.isFile()) {
			copyFile(src,dest);
		} else {
			File[] fileList = src.listFiles();
			
			for(File file : fileList) {
				File temp = Paths.get(dest.getAbsolutePath(),file.getName()).toFile();
				
				if(file.isDirectory()) {
					temp.mkdir();
					copy(file, temp);
				}else {
					copyFile(src,dest);
				}
			}
		}
	}
	
	public void copyFile(File src, File dest) {
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			int readByte;
			
			while((readByte = fis.read()) != -1) {
				fos.write(readByte);
			}
			fos.flush();
			
			fos.close();
			fis.close();
			System.out.println("���� ���� ����");
		}catch(Exception e) {
			System.out.println("���� ���� ����");
			e.printStackTrace();
		}
	}
}