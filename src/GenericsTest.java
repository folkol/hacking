import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GenericsTest {

    public static void main(String[] args) {
        Map<Integer, ?> map = new HashMap<>(null);
        System.out.println(map);

        List<Integer> list = new ArrayList(Arrays.asList(1,2,3));
        list.add(2);
        List<?> list2 = doSomething(list);
        list2.forEach(System.out::println);
        List<String> list3 = (List<String>) list2;
        list3.forEach(System.out::println);
    }

    private static List<?> doSomething(List<Integer> list) {
        return list;
    }

}
