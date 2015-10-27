import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {

    private static final String WORD = "hackerrank";
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(in.readLine());
        for(int c = 0; c < n; c++) {
            String line = in.readLine();

            if(line.startsWith(WORD) && line.endsWith(WORD)) {
                System.out.println(0);
            } else if (line.startsWith(WORD)) {
                System.out.println(1);
            } else if (line.endsWith(WORD)) {
                System.out.println(2);
            } else {
                System.out.println(-1);
            }
        }
    }
}
