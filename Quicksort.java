import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Quicksort {

    private static final int N = (int) 1e7;

    public static void main(String[] args) {
        int[] numbers = new Random().ints(N).toArray();
        long start = System.nanoTime();
        Arrays.sort(numbers);
        double elapsed = (System.nanoTime() - start) / 1e9;
        System.out.println("Reference (Arrays::sort): " + elapsed);
        assertSorted(numbers);

        List<Integer> list = new Random().ints(N).boxed().collect(toList());
        start = System.nanoTime();
        list = list.stream().sorted().collect(toList());
        elapsed = (System.nanoTime() - start) / 1e9;
        System.out.println("Reference (List::stream::sort): " + elapsed);
        assertSorted(numbers);

        numbers = new Random().ints(N).toArray();
        start = System.nanoTime();
        sortinplace(numbers);
        elapsed = (System.nanoTime() - start) / 1e9;
        System.out.println("In-place array: " + elapsed);
        assertSorted(numbers);

        list = new Random().ints(N).boxed().collect(toList());
        start = System.nanoTime();
        sortinplace(list);
        elapsed = (System.nanoTime() - start) / 1e9;
        System.out.println("In-place List: " + elapsed);
        assertSorted(list);

        List<Integer> withstreams = new Random().ints(N).boxed().collect(toList());
        start = System.nanoTime();
        withstreams = sortstreams(withstreams);
        elapsed = (System.nanoTime() - start) / 1e9;
        System.out.println("Streams: " + elapsed);
        assertSorted(withstreams);
    }

    public static List<Integer> sortstreams(List<Integer> xs) {
        if(xs.size() < 2) return xs;

        Integer pivot = xs.remove(0);
        return concat(sortstreams(xs.stream().filter(i -> i < pivot).collect(toList())),
                      pivot,
                      sortstreams(xs.stream().filter(i -> i > pivot).collect(toList())));
    }

    public static <T> List<T> concat(List<T> left, T pivot, List<T> right) {
        left.add(pivot);
        left.addAll(right);
        return left;
    }

    private static void assertSorted(int[] numbers) {
        for(int c = 0; c < numbers.length - 1; c++) {
            if(numbers[c] > numbers[c + 1]) {
                System.out.println(" ** NOT ORDERED! **");
                break;
            }
        }
    }

    public static void sortinplace(int[] a) {
        partitioninplace(a, 0, a.length - 1);
    }

    private static void partitioninplace(int[] a, int lo, int hi) {
        if (lo >= hi) return;

        int pivot = a[(lo + hi) / 2];

        int i = lo, j = hi;
        while (i <= j) {
            while (a[i] < pivot) i++;
            while (a[j] > pivot) j--;
            if (i <= j) swap(a, i++, j--);
        }

        partitioninplace(a, lo, j);
        partitioninplace(a, i, hi);
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void assertSorted(List<Integer> numbers) {
        for(int c = 0; c < numbers.size() - 1; c++) {
            if(numbers.get(c) > numbers.get(c + 1)) {
                System.out.println(" ** NOT ORDERED! **");
                break;
            }
        }
    }

    public static void sortinplace(List<Integer> a) {
        partitioninplace(a, 0, a.size() - 1);
    }

    private static void partitioninplace(List<Integer> a, int lo, int hi) {
        if (lo >= hi) return;

        int pivot = a.get((lo + hi) / 2);

        int i = lo, j = hi;
        while (i <= j) {
            while (a.get(i) < pivot) i++;
            while (a.get(j) > pivot) j--;
            if (i <= j) swap(a, i++, j--);
        }

        partitioninplace(a, lo, j);
        partitioninplace(a, i, hi);
    }

    private static void swap(List<Integer> a, int i, int j) {
        int t = a.get(i);
        a.set(i, a.get(j));
        a.set(j, t);
    }

}
