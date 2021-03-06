package Socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
	private Socket socket;
	
	public SocketClient(String host, int port) throws Exception{
		socket = new Socket(host,port);
	}
	
	public void close() throws IOException{
		socket.close();
	}
	
	public void send() throws IOException{
		String path = "";
		
		Scanner in = new Scanner(System.in);
		String input = in.next();
		
		boolean checkInput = true;
		while(checkInput) {
			System.out.println("선택하세요.");
			System.out.println("1번. 파일 전송");
			System.out.println("2번. 파일 수신");
			
			if(input.equals("1")) {
				OutputStream os = socket.getOutputStream();
				PrintWriter out = new PrintWriter(os,true);
				File inputFile = new File(path);
				checkInput = false;
				out.write(input);
				out.write(inputFile.getName());
				out.close();
				
				transferFile(inputFile);
			}else if(input.equals("2")) {
				OutputStream os = socket.getOutputStream();
				PrintWriter out = new PrintWriter(os,true);
				InputStream is = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				checkInput = false;
				
				out.write(input);
				String temp ="";
				String str ="";
				while((temp = br.readLine()) != null) {
					str += temp;
				}
				br.close();
				out.close();
				//파일 이름 받기
				String fileName = "";
				
				transferedFile(fileName);
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
		}
	}
	
	public void transferFile(File inputFile) throws IOException{
		
		InputStream is = new FileInputStream(inputFile);
		BufferedInputStream bis = new BufferedInputStream(is);
		
		OutputStream os = socket.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(os);
		
		int readByte;
		while((readByte = bis.read()) != -1) {
			bos.write(readByte);
		}
		bos.flush();
		
		bos.close();
		bis.close();
	}
	
	public void transferedFile(String path) throws IOException{
		File outputFile = new File(path);
		
		InputStream is = socket.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		
		OutputStream os = new FileOutputStream(outputFile);
		BufferedOutputStream bos = new BufferedOutputStream(os);
		
		int readByte;
		while((readByte = bis.read())!= -1) {
			bos.write(readByte);
		}
		bos.flush();
		
		bos.close();
		bis.close();
	}
}
