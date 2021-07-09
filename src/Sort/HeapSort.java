package Sort;

@SuppressWarnings("ALL")
public class HeapSort {
    public static void sort(Comparable[] num) {
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        Comparable[] heap = new Comparable[num.length + 1];
        for (int i = 1; i < heap.length; i++) {
            heap[i] = num[i - 1];
        }
        order(heap);
        for (int i = 0; i < num.length; i++) {
            num[i] = heap[1];
            heap[1] = 99999999.99D;
            sink(heap, 1);

        }
        endTime = System.currentTimeMillis();
        System.out.printf("堆排序耗时%dms\n", endTime - startTime);
    }

    private static void order(Comparable[] heap) {
        int len = heap.length - 1;
        for (int i = len / 2; i > 0; i--) {
            sink(heap, i);
        }
    }

    public static void sink(Comparable[] heap, int i) {

        while (i * 2 <= heap.length - 1) {
            int c = 2 * i;
            if (c < heap.length - 1 && heap[c].compareTo(heap[c + 1]) > 0) {
                c++;
            }
            if (heap[i].compareTo(heap[c]) <= 0) break;
            example.exchange(heap, i, c);
            i = c;

        }
    }
}
