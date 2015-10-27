import java.net.URL;

public class Resolve {
    public static void main(String[] args) throws Exception {
        System.out.println(new URL("file:///tmp/lol.txt").getContent());
    }
}
