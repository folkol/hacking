import java.text.DecimalFormat;

public class DecimalFormatTest {
    public static void main(String[] args) {
//        result = evaluateExpression(parts);
        double result = 234.324;
        DecimalFormat df = new DecimalFormat("#.##");
        String dx = df.format(result);
        System.out.println(dx);
    }
}
