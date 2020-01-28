
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.net.Socket;

public class object10client {

    public static void main(String[] args) throws Exception {

        System.out.println("client Started");
        Socket soc = new Socket("127.0.0.1", 8086);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(soc.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(soc.getInputStream());

        frame[] obj = new frame[10];
        obj[0] = new frame();
        obj[0].framed((float) 3.5, "Memory", 7, FALSE);
        obj[1] = new frame();
        obj[1].framed((float) 4.5, "Register", 9, FALSE);
        obj[2] = new frame();
        obj[2].framed((float) 5.5, "Circuit", 11, FALSE);
        obj[3] = new frame();
        obj[3].framed((float) 6.5, "Partition", 13, FALSE);
        obj[4] = new frame();
        obj[4].framed((float) 7.5, "Process", 15, FALSE);
        obj[5] = new frame();
        obj[5].framed((float) 8.5, "Thread", 17, FALSE);
        obj[6] = new frame();
        obj[6].framed((float) 9.5, "Flag", 19, FALSE);
        obj[7] = new frame();
        obj[7].framed((float) 10.5, "Data", 21, FALSE);
        obj[8] = new frame();
        obj[8].framed((float) 11.5, "Swapping", 23, FALSE);
        obj[9] = new frame();
        obj[9].framed((float) 12.5, "Algorithm", 25, FALSE);

        for (int i = 0; i < 10; i++) {

            int count = 0, x;

            String s = Integer.toBinaryString((int) obj[i].protocolID);

            int k = Float.floatToIntBits(obj[i].header);

            String s1 = Integer.toBinaryString((int) k);

            String result = "";
            char[] messChar = obj[i].data.toCharArray();

            for (int j = 0; j < messChar.length; j++) {
                result += Integer.toBinaryString(messChar[j]) + " ";
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
                obj[i].Trailer = TRUE;
            }

            objectOutputStream.writeObject(obj[i]);
            frame returnframe = (frame) objectInputStream.readObject();

        }
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
