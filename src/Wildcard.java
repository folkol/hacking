import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Wildcard {

    static interface Something {
        public void doSomething();
    }

    static class SomethingA implements Something {
        @Override
        public void doSomething() {
            System.out.println("A");
        }
    }

    static class SomethingB implements Something {
        @Override
        public void doSomething() {
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        List<Something> l1 = new ArrayList<>();
        List<SomethingA> l2 = new ArrayList<>();
        List<SomethingB> l3 = new ArrayList<>();
        myMethod(l1);
        myMethod(l2);
        myMethod(l3);
    }

    private static void myMethod(List<? extends Something> list) {
        list.forEach(System.out::println);
    }

}
