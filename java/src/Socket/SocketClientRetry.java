package Socket;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClientRetry {
	Socket socket;
	
	public SocketClientRetry(String host, int port) throws IOException{
		this.socket = new Socket(host,port);
	}
	
	public void sendFile(String path) {
		try {
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			File file = new File(path);
			InputStream is = new FileInputStream(file);
			Long fileLength = file.length();
			
			dos.writeUTF(file.getName());
			dos.writeLong(fileLength);
			
			int data = 0;
			int readByte;
			while((readByte = is.read()) != -1) {
				dos.write(readByte);
				data++;
				
				System.out.println("파일 전송" +(data/fileLength)+"% 진행 완료");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			SocketClientRetry client = new SocketClientRetry("localhost",20000);
			client.sendFile("C:\\Users\\skylo\\Desktop\\client\\client.txt");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
