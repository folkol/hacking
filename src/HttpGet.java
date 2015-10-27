import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class HttpGet {

    public static void main(String[] args) throws Exception {
        InputStream is = new URL("http://www.google.com").openStream();
        List l = null;
        for(Object o : l);
    }
}
