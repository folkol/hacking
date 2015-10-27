import java.util.Arrays;
import java.util.List;

public class UnitTest {

    public static void main(String[] args) {
        SumService sumService = new SumService(new MockDatabase());
        if(sumService.calculateSum() != 300) {
            System.out.println("TEST FAILED");
        }
    }

    static class MockDatabase extends Database {
        @Override
        public List<Integer> getAll() {
            return Arrays.asList(100, 100, 100);
        }
    }

}
