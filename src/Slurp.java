import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Slurp {
    public static void main(String[] args) throws Exception {
        File file = new File("/tmp/somefile.txt");
        InputStream is = new FileInputStream(file);
        System.out.println(new Scanner(is).useDelimiter("\\A").next());

        // Path file = Paths.get(args[0]);
        // for(String line : Files.readAllLines(file, Charset.defaultCharset()))
        // {
        // // Do something with "line"
        // }
    }
}
