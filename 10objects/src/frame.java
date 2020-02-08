
import java.io.Serializable;

public class frame implements Serializable {

    float header;
    String data;
    int protocolID;
    Boolean Trailer;
    float acknowledgement;

    void framed(float header, String data, int protocolID, Boolean Trailer, float acknowledgement) {
        this.header = header;
        this.data = data;
        this.protocolID = protocolID;
        this.Trailer = Trailer;
        this.acknowledgement = acknowledgement;
    }

    void veiwframe() {
        System.out.println(header + "\n" + data + "\n" + protocolID + "\n" + Trailer + "\n");
    }

}
