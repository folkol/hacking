import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {
        int[] numbers = new Random().ints(100).toArray();

        for (int i : numbers) {
            System.out.println(i);
        }

        sort(numbers);

        for (int i : numbers) {
            System.out.println(i);
        }
    }

    private static void sort(int[] numbers) {
        while (!sorted(numbers)) {
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i - 1] > numbers[i]) {
                    swap(numbers, i - 1, i);
                }
            }
        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private static boolean sorted(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] > numbers[i]) {
                return false;
            }
        }
        return true;
    }

}
