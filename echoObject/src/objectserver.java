
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Boolean.TRUE;
import java.net.Socket;
import java.net.ServerSocket;

public class objectserver {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Wating for client...");
        ServerSocket ss = new ServerSocket(8086);
        Socket soc = ss.accept();
        System.out.println("Connection Established");

        ObjectInputStream objectInputStream = new ObjectInputStream(soc.getInputStream());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(soc.getOutputStream());

        frame obj = (frame) objectInputStream.readObject();
        objectOutputStream.writeObject(obj);
        obj.veiwframe();

        soc.close();

    }

}
