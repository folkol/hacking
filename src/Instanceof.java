import java.util.Arrays;
import java.util.List;


public class Instanceof {

    public static void main(String[] args) {
        foo("asd", String.class);
        foo('S', String.class);
        foo(1, int.class);

        System.out.println(int.class.isInstance(1));
        someMethod(Arrays.asList(2));
    }

    static void someMethod(List<? extends Number> list) {
        System.out.println(list.get(0));
    }

    private static <T> void foo(Object obj, Class<T> clazz) {
//        if(clazz.isInstance(obj)) {
//            System.out.println("Eureka!");
//        }
        if(clazz.isAssignableFrom(obj.getClass())) {
            System.out.println("Eureka!");
        }
    }

}
