public class SumService {

    private Database db;

    public SumService(Database db) {
        this.db = db;
    }

    public int calculateSum() {
        int sum = 0;
        for(Integer i : db.getAll()) {
            sum += i;
        }
        return sum;
    }

}
