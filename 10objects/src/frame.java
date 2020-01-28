
import java.io.Serializable;

public class frame implements Serializable {

    float header;
    String data;
    int protocolID;
    Boolean Trailer;

    void framed(float header, String data, int protocolID, Boolean Trailer) {
        this.header = header;
        this.data = data;
        this.protocolID = protocolID;
        this.Trailer = Trailer;
    }

    void veiwframe() {
        System.out.println(header + "\n" + data + "\n" + protocolID + "\n" + Trailer + "\n");
    }

}