
/**
 * Server side of a bidirectional half-duplex connection
 * @author hasan_rocky
 */

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Server {

    public static void main (String[] args) {

        try {
            System.out.println("Waiting..");
            ServerSocket ser = new ServerSocket(9806);
            Socket soc = ser.accept();
            System.out.println("Established");

            //BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //from System
            ObjectInputStream cin = new ObjectInputStream(soc.getInputStream()); //from client
            ObjectOutputStream cout = new ObjectOutputStream(soc.getOutputStream()); //to client

            //receiving from client
            System.out.println("Receiving object from client...");
            Frame inFrame = (Frame) cin.readObject();
            System.out.println(inFrame.header + " " + inFrame.data + " " + inFrame.protocolID + " " + inFrame.tailer);
            System.out.println("Finished.");
            System.out.println();

            //sending to client
            Frame outFrame = inFrame;
            System.out.println("Resending object to client...");
            cout.writeObject(outFrame);
            System.out.println(outFrame.header + " " + outFrame.data + " " + outFrame.protocolID + " " + outFrame.tailer);
            System.out.println("Sent.");
            System.out.println();


        } catch (Exception e) {

        }
    }

}
