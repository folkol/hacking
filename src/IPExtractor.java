import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPExtractor {

    static Pattern p = Pattern.compile("\\.((\\d*\\.){3}\\d*)$");

    public static void main(String[] args) {
        String src = "1.2345.6.77.88.9.1.192.168.1.2";
        System.out.println(extractIp(src));
    }

    private static String extractIp(String src) {
        Matcher m = p.matcher(src);

        String ip = "";
        if (m.find()) {
            ip = m.group(1);
        }
        return ip;
    }

}
