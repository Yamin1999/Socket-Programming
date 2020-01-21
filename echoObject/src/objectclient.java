
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.net.Socket;

public class objectclient {

    public static void main(String[] args) throws Exception {

        System.out.println("client Started");
        Socket soc = new Socket("127.0.0.1", 8086);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(soc.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(soc.getInputStream());
        frame obj = new frame();
        obj.frame((float) 3.5, "DATA", 7, FALSE);

        int count = 0, x;

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
            obj.Tailer = TRUE;
        }

        objectOutputStream.writeObject(obj);
        frame returnframe = (frame) objectInputStream.readObject();

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
