
import java.net.Socket;
import java.io.*;

public class ClientObject {

    public static void main(String[] args) throws Exception {

        System.out.println("client Started");
        Socket soc = new Socket("127.0.0.1", 8080);
    }
}
