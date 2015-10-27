import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Compare {
    static class Lol{}
    public static void main(String[] args) {
        Collection<Lol> objects = new ArrayList<>();
        objects.add(new Lol());
        objects.add(new Lol());
        objects.add(new Lol());

        objects.forEach(System.out::println);
    }
}
