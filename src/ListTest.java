import java.util.ArrayList;
import java.util.List;


public class ListTest {


        public static void main(String args[]) {

                List<String> myList = new ArrayList<String>();
                myList.add("one");
                myList.add("two");
                myList.add("three");


                for (int n = 0; n < myList.size(); n++) {
                        List<String> tmp = new ArrayList<String>();
                        System.out.println("element: " + n + " is first in this list");
                        tmp.add(myList.get(n));
                        for (int h = 1; h < myList.size(); h++) {
                                if (h == n) {
                                        // skip this element, its the first in this list
                                } else {
                                        System.out.println("h: " + h);
                                        tmp.add(h, myList.get(h));
                                }
                        }
                        System.out.println(tmp);

                }
        }
}
