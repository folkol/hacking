import java.nio.ByteBuffer;


public class ByteBufferTest {

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(100);
        bb.put((byte)0xff);
        System.out.println(bb.asCharBuffer());
    }

}
