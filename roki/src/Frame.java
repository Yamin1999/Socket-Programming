
import java.io.Serializable;

public class Frame implements Serializable{
    float header;
    String data;
    int protocolID;
    Boolean tailer;

    Frame(float h, String d, int p, Boolean t) {
      this.header = h;
      this.data = d;
      this.protocolID = p;
      this.tailer = t;
    }
}
