public class CatastrophicBacktracking {

    public static void main(String[] args) {
        int counter = 0;
        String str = "aaaaaaaaaab";
        for (int c = 0; c < 5000000; c++) {
            if (str.matches("(aab)+")) counter++;
        }
        System.out.println(counter);
    }
}
