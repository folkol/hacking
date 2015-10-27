import java.io.File;
import java.io.RandomAccessFile;


public class FileSetLength {

    public static void main(String[] args) throws Exception {
        File file = new File("/tmp/test.bin");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.setLength(100000);
    }

}
