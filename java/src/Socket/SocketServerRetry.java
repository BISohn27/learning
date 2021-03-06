package Socket;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerRetry {
ServerSocket server;
	
	public SocketServerRetry(int port) throws IOException{
		this.server = new ServerSocket(port);
	}
	
	public void receiveFile(String path) throws Exception{
		Socket socket = server.accept();
		
		System.out.println("서버 통신 시작");
		
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		
		String fileName = dis.readUTF();
		long totalData = dis.readLong();
		
		File file = new File(path + "\\" +fileName);
		System.out.println(fileName);
		System.out.println(totalData);
		file.mkdir();
		
		OutputStream os = new FileOutputStream(file);
		
		long data = 0;
		int readByte;
		while((readByte = dis.read()) != -1) {
			++data;
			os.write(readByte);
			
			System.out.println("파일 수신 "+ (data/totalData) + "% 완료");
		}
		os.flush();
		
		System.out.println("파일 수신 완료");
		System.out.println("파일명: " + fileName);
		System.out.println("파일 경로: " + file.getAbsolutePath());
		System.out.println("파일크기: " + (data/1000) + "kbyte");
		
		dis.close();
		os.close();
	}
	
	public void close() throws IOException{
		server.close();
	}
	
	public static void main(String[] args) {
		try {
			SocketServerRetry server = new SocketServerRetry(20000);
			server.receiveFile("C:\\Users\\skylo\\Desktop\\server");
			server.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
