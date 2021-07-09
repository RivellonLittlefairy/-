package Sort;

public class Quick {
    public static void sort(Comparable[] num) {
        long startTime,endTime;
        startTime=System.currentTimeMillis();
        sort(num, 0, num.length - 1);
        endTime=System.currentTimeMillis();
        System.out.printf("快速排序耗时%dms\n",endTime-startTime);
    }

    public static void sort(Comparable[] num, int fir, int las) {
        if (fir >= las) return;
        int mid = partition(num, fir, las);
        sort(num, fir, mid - 1);
        sort(num, mid + 1, las);
    }

    public static int partition(Comparable[] num, int fir, int las) {
        int left = fir+1;
        int right = las;
        int mid = fir;
        while (true) {
            while (num[left].compareTo(num[mid]) < 0) {
                if (left == las) break;
                left++;
            }
            while (num[mid].compareTo(num[right]) < 0) {
                if (right == fir) break;
                right--;
            }
            if (left >= right) break;
            example.exchange(num, left, right);
        }
        example.exchange(num, mid, right);
        return right;
    }
}
