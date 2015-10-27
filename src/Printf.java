import java.util.logging.Logger;


public class Printf {

    static Logger LOG = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        for (int c = 1; c < 10; c++) {
            int pow = (int) Math.pow(3, c);
            System.out.printf("(%5d, %6.2f, %#10x)%n", pow, Math.sqrt(pow), pow * pow);
            System.out.format("(%5d, %6.2f, %#10x)%n", pow, Math.sqrt(pow), pow * pow);
            System.out.print(String.format("(%5d, %6.2f, %#10x)%n", pow, Math.sqrt(pow), pow * pow));
            System.out.println(String.format("(%5d, %6.2f, %#10x)", pow, Math.sqrt(pow), pow * pow));
        }
    }

}
