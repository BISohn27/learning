package Socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	private ServerSocket server;
	
	public SocketServer(int port) throws IOException{
		server = new ServerSocket(port);
	}
	
	public void transferedFile(String path) throws IOException{
		System.out.println("The Server is ready");
		
		Socket socket = server.accept();
		File outFile = new File(path);
		
		InputStream is = socket.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		
		OutputStream os = new FileOutputStream(outFile);
		BufferedOutputStream bos = new BufferedOutputStream(os);
		
		int readByte;
		
		while((readByte =bis.read()) != -1) {
			bos.write(readByte);
		}
		bos.flush();
		
		bos.close();
		bis.close();
	}
	
	public void close() throws IOException{
		server.close();
	}
	
	public void transferFile(String path) throws IOException{
		System.out.println("The Server is ready");
		
		Socket socket = server.accept();
		File inputFile = new File(path);
		
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
}
