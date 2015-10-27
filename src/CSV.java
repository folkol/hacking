
public class CSV {

    public static void main(String[] args) {
        System.out.println("Hello world");
        System.out.println(toCSV("Hello world") + " " + toCSV2("Hello world"));
        System.out.println(toCSV("\"Hello,, \"world\"") + " " + toCSV2("\"Hello,, \"world\""));
    }

    public static String toCSV(final String str) {
        if ((str == null) || (str.trim().length() < 1)) {
            return " ";
        }

        // Check for a comma
        final int commaIndex = str.indexOf(',');

        // Check for quotes
        final int quoteIndex = str.indexOf('"');

        if(commaIndex < 0 && quoteIndex < 0)
        {
            return String.format("\"%s\"", str);
        }
        else
        {
            // We have quotes and commas in the string, so backquote
            StringBuilder sb = new StringBuilder(50);
            final int len = str.length();
            for (int i = 0; i < len; ++i) {
                final char ch = str.charAt(i);
                if (ch == '"') {
                    sb.append("\"\\");
                }
                sb.append(ch);
            }
            return sb.toString().replaceAll(",", "|");
        }
    }

    public static String toCSV2(final String str) {
        if (str == null || str.trim().isEmpty()) {
            return " ";
        }

        final boolean lacksComma = str.indexOf(',') == -1;
        final boolean lacksQuotes = str.indexOf('"') == -1;

        if (lacksComma && lacksQuotes)
        {
            return String.format("\"%s\"", str);
        }

        return str.replaceAll("\"", "\" \\ \"").replaceAll(",", "|");
    }

}
