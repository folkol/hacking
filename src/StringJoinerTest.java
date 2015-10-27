import java.util.StringJoiner;

public class StringJoinerTest {
    public static void main(String[] args) {

        String ss = joinSomeStrings("str1", "str2", "str3");

        System.out.println(ss);

        StringJoinerTest sj = new StringJoinerTest();

        System.out.println(String.join("/", "str1", "str2", "str3"));
    }

    private static String joinSomeStrings(String s1, String s2, String s3) {
        return String.join("/", s1, s2, s3);
    }

    private static String joinSomeStringsWithJoined(StringJoiner sj, String s1, String s2, String s3) {

        return String.join("/", s1, s2, s3);
    }
}
