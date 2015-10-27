import static java.util.Arrays.*;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


public class ForkJoinSort {

    private static final int WARMUP_COUNT = 20000;
    private static final int ARRAY_SIZE = 100000;
    private static ForkJoinPool pool = new ForkJoinPool();

    public static void main(String[] args) {
        int[] numbers = new Random().ints(ARRAY_SIZE).toArray();
        for(int i = 0; i < WARMUP_COUNT; i++) {
            sort(Arrays.copyOf(numbers, numbers.length));
            Arrays.sort(Arrays.copyOf(numbers, numbers.length));
            Arrays.parallelSort(Arrays.copyOf(numbers, numbers.length));
        }

        numbers = new Random().ints(ARRAY_SIZE).toArray();
        long begin = System.nanoTime();
        sort(numbers);
        long elapsed = System.nanoTime() - begin;
        System.out.println("Elapsed time (Fork/Join): " + elapsed/10e9);

        numbers = new Random().ints(ARRAY_SIZE).toArray();
        begin = System.nanoTime();
        Arrays.sort(numbers);
        elapsed = System.nanoTime() - begin;
        System.out.println("Elapsed time (Arrays::sort): " + elapsed/10e9);

        numbers = new Random().ints(ARRAY_SIZE).toArray();
        begin = System.nanoTime();
        Arrays.parallelSort(numbers);
        elapsed = System.nanoTime() - begin;
        System.out.println("Elapsed time (Arrays::parallellSort): " + elapsed/10e9);
    }

    private static int[] sort(int[] numbers) {
        MergeSort task = new MergeSort(numbers);
        pool.invoke(task);
        return task.sorted;
    }

    static class MergeSort extends RecursiveAction {

        private int[] numbers;
        private int[] sorted;

        public MergeSort(int[] numbers) {
            this.numbers = numbers;
            this.sorted = new int[numbers.length];
        }

        @Override
        protected void compute() {
            if(numbers.length <= 1) {
                sorted = numbers;
            } else {
                MergeSort left = new MergeSort(copyOfRange(numbers, 0, numbers.length / 2));
                MergeSort right = new MergeSort(copyOfRange(numbers, numbers.length / 2, numbers.length));
                invokeAll(left, right);
                merge(left.sorted, right.sorted);
            }
        }

        private void merge(int[] left, int[] right) {
            for(int i = 0, j = 0, k = 0; k < sorted.length;) {
                int next;
                if(i < left.length && j < right.length) {
                    next = left[i] < right[j] ? left[i++] : right[j++];
                } else if(i == left.length) {
                    next = right[j++];
                } else {
                    next = left[i++];
                }
                sorted[k++] = next;
            }
        }
    }
}
