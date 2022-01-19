package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;

public class EncodeFileString {
	public String modifyEncoding(String src) {
		File file = new File(src);
		File dest = Paths.get(file.getAbsolutePath(),"modified_"+file.getName()).toFile();
		String encodedStr = null;
		
		try {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis,"euc-kr");
			BufferedReader br = new BufferedReader(isr);
			
			FileOutputStream fos = new FileOutputStream(dest);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			
			String temp ="";
			while((temp = br.readLine())!= null) {
				bw.write(temp);
			}
			bw.flush();
			
			bw.close();
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dest.getName();
	}
}
