import java.util.Scanner;

public class Beads {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int t = in.nextInt();
        for(int c = 0; c < t; c++) {
            nextTest();
        }
    }

    private static void nextTest() {
        int n = in.nextInt();

        long numBeads = 1;
        long permutations = 1;
        for(int c = 0; c < n; c++) {
            int i = in.nextInt();
//            long possibilities = numBeads * factorial(i-1);
//            permutations *= possibilities;
            numBeads += i;
        }
        System.out.println(permutations % 1000000007L);
    }

}
