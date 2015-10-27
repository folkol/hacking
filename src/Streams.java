import java.io.File;
import java.lang.reflect.Method;


public class Streams {

    static class Person {
        public int age;
        public String name;
        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception {
//        List<Person> items = Arrays.asList(new Person(10, "Matte"),
//                                           new Person(20, "Emma"),
//                                           new Person(30, "Fredrik"));
//        List<String> someNames = items.stream()
//                                      .filter(x -> x.age > 15)
//                                      .map(x -> x.name)
//                                      .collect(toList());
        Method method = System.out.getClass().getMethod("println");
        myMethod(method);
    }

    static void myMethod(Method c) throws Exception {
        c.invoke(System.out, "WUT");
    }

}
