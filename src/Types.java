import static java.lang.String.*;


public class Types {

    public static void main(String[] args) {
        printParents(boolean.class, Boolean.class, int.class, float.class, int[].class, float[].class, Object.class, Integer.class, Types.class);
    }

    static void printParents(Class<?>... classes) {
        System.out.format("%-30.30s %-20.20s\n", "Class", "Parent");
        System.out.println("=============================================================");
        for(Class<?> c : classes) {
            System.out.println(format("%-30.30s %-30.30s", c, c.getSuperclass()));
        }
    }

}
