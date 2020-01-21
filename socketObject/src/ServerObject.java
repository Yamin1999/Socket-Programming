import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class ServerObject {

	public static void main(String[] args) throws Exception
	{
					
			System.out.println("Wating for client...");
			ServerSocket ss = new ServerSocket(8080);
			Socket soc = ss.accept();
			System.out.println("Connection Established");
        }
}