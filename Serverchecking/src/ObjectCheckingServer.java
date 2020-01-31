
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Boolean.TRUE;
import java.net.Socket;
import java.net.ServerSocket;

public class ObjectCheckingServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Wating for client...");
        ServerSocket ss = new ServerSocket(8086);
        Socket soc = ss.accept();
        System.out.println("Connection Established");

        ObjectInputStream objectInputStream = new ObjectInputStream(soc.getInputStream());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(soc.getOutputStream());

        frame obj = (frame) objectInputStream.readObject();
        objectOutputStream.writeObject(obj);
        
                int count = 0, x;
                boolean check;

        String s = Integer.toBinaryString((int) obj.protocolID);

        int k = Float.floatToIntBits(obj.header);

        String s1 = Integer.toBinaryString((int) k);

        String result = "";
        char[] messChar = obj.data.toCharArray();

        for (int i = 0; i < messChar.length; i++) {
            result += Integer.toBinaryString(messChar[i]) + " ";
        }

        System.out.println("Binary String of data = " + result);
        System.out.println("Binary String of ProtocolID = " + s);
        System.out.println("Binary String of header = " + s1);

        x = onecount(result);
        count += x;
        x = onecount(s);
        count += x;
        x = onecount(s1);
        count += x;

        System.out.println("No. of 1s:" + count);

        if (count % 2 != 0) {
        if(obj.Trailer == true)
        {
            System.out.println("Client Side Message is correct");
        }
        else
        {
           System.out.println("Client Side Message is Worng!!!"); 
        }
        }
        else
        {        
        if(obj.Trailer == false)
        {
            System.out.println("Client Side Message is correct");
        }
        else
        {
           System.out.println("Client Side Message is Worng!!!"); 
        }
        }
        
     
       // obj.veiwframe();

        soc.close();

    }
    
    
    public static int onecount(String x) {
        int count1 = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '1') {
                count1++;
            }
        }
        return count1;
    }

}


