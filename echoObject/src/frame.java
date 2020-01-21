
import java.io.Serializable;

public class frame implements Serializable {

    float header;
    String data;
    int protocolID;
    Boolean Tailer;

    void frame(float header, String data, int protocolID, Boolean Tailer) {
        this.header = header;
        this.data = data;
        this.protocolID = protocolID;
        this.Tailer = Tailer;
    }

    void veiwframe() {
        System.out.println(header + "\n" + data + "\n" + protocolID + "\n" + Tailer + "\n");
    }

}
