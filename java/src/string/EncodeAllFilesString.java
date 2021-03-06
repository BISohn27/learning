package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;

public class EncodeAllFilesString {
	FileInputStream fis;
	FileOutputStream fos;
	InputStreamReader isr;
	OutputStreamWriter osw;
	BufferedReader br;
	BufferedWriter bw;
	
	public void encodeDirectory(String dirSrc, String charset) {
		File file = new File(dirSrc);
		
		modifyDirectory(file,charset);
	}
	
	public void modifyDirectory(File src, String charset) {
		if(src.isFile()) {
			modifyText(src,charset);
		} else {
			File[] fileList = src.listFiles();
			
			for(File file : fileList) {
				if(file.isFile()) {
					modifyText(file,charset);
				} else if(file.isDirectory()) {
					modifyDirectory(file,charset);
				}
			}
		}
	}
	
	public void modifyText(File src, String charset) {
		String fileName = src.getName();
		String temp = fileName.substring(fileName.indexOf(".")+1);
		
		if(temp.equals("txt")) {
			modify(src,charset);
		} else {
			return;
		}
	}
	
	public void modify(File src, String charset) {
		try {
			fis = new FileInputStream(src);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			
			fos = new FileOutputStream(src);
			osw = new OutputStreamWriter(fos,charset);
			bw = new BufferedWriter(osw);
			
			String str ="";
			String temp ="";
			while((temp = br.readLine())!= null) {
				str += temp;
			}
			bw.write(str);
			
			bw.flush();
			
			bw.close();
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
