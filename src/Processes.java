import java.util.ArrayList;
import java.util.List;

public class Processes {
    static public List<Integer> process1(int n) {
        List<Integer> someList = new ArrayList<Integer>();
        for (int k = 0; k < n; k++)
            someList.add(new Integer(k));
        return someList;
    }

    static public List<Integer> process2(int n) {
        List<Integer> someList = new ArrayList<Integer>();
        for (int k = 0; k < n; k++)
            someList.add(k, new Integer(k));
        return someList;
    }

    public static void main(String[] args) {
        process1(10).forEach(System.out::print);
        System.out.println("");
        process2(10).forEach(System.out::print);
    }

}
