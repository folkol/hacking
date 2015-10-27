import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    public static void main(String[] args) {
        List<Base> list = new ArrayList<>();
        list.add(new Base());
        list.add(new NewBase());
//        method(list);

        List<NewBase> list2 = new ArrayList<>();
//        list2.add(new Base());
        list2.add(new NewBase());
        List<? extends Base> method = method(list2);
//        method.add(new NewBase());
    }

    private static List<? extends Base> method(List<? extends Base> list) {
        for(Base b : list) {
            b.hello();
        }

        return list;
    }
}
