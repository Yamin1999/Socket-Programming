import java.net.Socket;
import java.io.*;

public class echoclient {

    public static void main(String[] args) throws Exception {

        System.out.println("client Started");
        Socket soc = new Socket("127.0.0.1", 8080);
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

        PrintStream out = new PrintStream(soc.getOutputStream());

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while (true) {

            System.out.println("Client : ");
            str = userInput.readLine();

            out.println(str);
            
            if(str.equalsIgnoreCase("BYE"))
            {
                System.out.println("Connection Ended By Client");
                break;
            }

            str = in.readLine();

            System.out.println("Server : " + str);

        }
        soc.close();
    }

 

}
