import java.util.HashSet;
import java.util.Set;

public class GetFromSet {

    public static void main(String[] args) {
        Set<Object> objects = new HashSet<>();
        objects.add("Hello, world");

        Object next = objects.iterator().next();
        System.out.println(next);
    }
}
