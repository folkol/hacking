
public class BooleanInterned {

    public static void main(String[] args) {
        Boolean a = Boolean.parseBoolean("True");
        Boolean b = Boolean.valueOf("truE");
        System.out.println(a == b);
    }

}
