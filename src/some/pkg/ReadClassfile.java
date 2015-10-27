package some.pkg;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class ReadClassfile {

    public static void main(String[] args) {
        String classname = ReadClassfile.class.getSimpleName();
        String filename = classname.replace(".", File.separator) + ".class";
        InputStream is = ReadClassfile.class.getResourceAsStream(filename);

        System.out.println(new Scanner(is).useDelimiter("\\A").next());
    }

}
