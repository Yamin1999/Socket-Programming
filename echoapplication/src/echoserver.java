

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class echoserver {

	public static void main(String[] args) throws Exception
	{
					
			System.out.println("Wating for client...");
			ServerSocket ss = new ServerSocket(8080);
			Socket soc = ss.accept();
			System.out.println("Connection Established");
	
			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			
			PrintStream out = new PrintStream(soc.getOutputStream()); 
			
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			String str;
			Scanner sc = new Scanner(System.in);
			
			while(true)
			{
		    str=in.readLine();

			System.out.println("Client : "+ str);
			
			System.out.print("Server : ");
		        str=sc.nextLine();
               if(str.equalsIgnoreCase("BYE"))
            {
                System.out.println("Connection Ended By Server");
                break;
            }
			out.println(str);
			}
                        
              
                        
			
	}
  
        
        
}

		

		
	

