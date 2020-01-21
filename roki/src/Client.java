
/**
 * Client side of a bidirectional half-duplex connection
 * @author hasan_rocky
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.io.*;

public class Client {

    public static void main(String[] args) {

        try {
            Socket soc = new Socket("localhost", 9806);

            //BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //from System
            System.out.println(".");
            ObjectInputStream sin = new ObjectInputStream(soc.getInputStream()); //from client
            System.out.println("..");
            ObjectOutputStream sout = new ObjectOutputStream(soc.getOutputStream()); //to client

            //sending to server
            System.out.println("Sending object to server...");
            Frame outFrame = new Frame(0.5f, "data", 10, true);
            sout.writeObject(outFrame);
            System.out.println(outFrame.header + " " + outFrame.data + " " + outFrame.protocolID + " " + outFrame.tailer);
            System.out.println("Sent.");
            System.out.println();

            //receiving from server
            Frame inFrame = (Frame)sin.readObject();
            System.out.println("Return object from server: " + inFrame.header + " " + inFrame.data + " " + inFrame.protocolID + " " + inFrame.tailer);


        } catch (Exception e) {

        }
    }
}
