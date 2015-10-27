import java.util.Scanner;

public class Hax {

    public static void main(String[] args) {
        System.out.println("Hello world");
        java.util.Scanner input = new Scanner(System.in);
        int number = -1;
        do {
            try {
                number = input.nextInt();
            } catch (Exception e) {
                System.out.println("Write a number");
                input.next();
            }
        } while (number == -1);

        while (number > 0) {
            number--;
            System.out.println("Hej");
        }
    }

}
