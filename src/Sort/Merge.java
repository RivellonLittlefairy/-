package Sort;

public class Merge {
    private static Comparable[] nums;

    public static void merge(Comparable[] num, int fir, int mid, int las) {
        int i = fir;
        int j = mid + 1;
        for (int k = fir; k <= las; k++) {
            nums[k] = num[k];
        }
        for (int k = fir; k <= las; k++) {
            if (i > mid) num[k] = nums[j++];
            else if (j > las) num[k] = nums[i++];
            else if (nums[i].compareTo(nums[j]) > 0) num[k] = nums[j++];
            else num[k] = nums[i++];
        }
    }

    public static void sort(Comparable[] num) {
        long startTime,endTime;
        startTime=System.currentTimeMillis();
        nums = new Comparable[num.length];
        sort(num, 0, num.length - 1);
        endTime=System.currentTimeMillis();
        System.out.printf("归并排序耗时%dms\n",endTime-startTime);
    }

    public static void sort(Comparable[] num, int fir, int las) {
        if (las <= fir) return;
        int mid = fir + (las - fir) / 2;
        sort(num, fir, mid);
        sort(num, mid + 1, las);
        merge(num, fir, mid, las);
    }

    public static void sort2(Comparable[] num) {
        nums = new Comparable[num.length];
        int len = num.length;
        for (int sz = 1; sz < len; sz = sz + sz) {
            for (int i = 0; i < len - sz; i += sz + sz) {
                merge(num, i, i + sz - 1, Math.min(i + sz + sz - 1, len - 1));
            }
        }

    }
}
