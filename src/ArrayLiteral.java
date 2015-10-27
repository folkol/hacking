public class ArrayLiteral {

    public static void main(String[] args) {
        Object[] a = new Object[] { 0 };
        Object[] b = new Object[] { new Integer(0) };
        System.out.println(a[0]);
        System.out.println(b[0]);

        testName(0);
    }

    public static void testName(Object o) {
        System.out.println("OBJ");
    }

    public static void testName(Integer o) {
        System.out.println("INT");
    }

}
