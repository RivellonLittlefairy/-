package Sort;

public class Shell {
    public static void sort(Comparable[] num) {
        long startTime,endTime;
        startTime=System.currentTimeMillis();
        int len = num.length;
        int h = 1;
        while (h < len / 3) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                int ii = i;
                for (int j = i; j >= 0; j = j - h) {
                    if (num[j].compareTo(num[ii]) > 0) {
                        example.exchange(num, ii, j);
                        ii -= h;
                    }
                }
            }
            h = h / 3;
        }
        endTime=System.currentTimeMillis();
        System.out.printf("希尔排序耗时%dms\n",endTime-startTime);
    }
}
