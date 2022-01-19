package string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileStringReplacement {
	StringReplacement fsr = new StringReplacement();
	
	public void replaceFileString(String src, String dest, String target, String replacement) {
		File source = new File(src);
		File destination = new File(dest);
		
		String str = "";
		
		try {
			FileReader fr = new FileReader(source);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(dest);
			
			destination.mkdirs();
			
			while((str = br.readLine()) != null) {
				str = fsr.replace(str, target, replacement);
				fw.write(str);
			}
			fw.flush();
			
			fw.close();
			br.close();
		}catch(Exception e) {
			System.out.println("문자 치환에 실패하였습니다.");
			e.printStackTrace();
		}
	}
}
