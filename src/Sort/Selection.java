package Sort;

public class Selection {
    public static void sort(Comparable[] num) {
        long startTime,endTime;
        startTime=System.currentTimeMillis();
        for (int i = 0; i < num.length; i++) {
            Comparable min = num[i];
            int a = i;
            for (int j = i; j < num.length; j++) {
                if (min.compareTo(num[j])>0) {
                    min = num[j];
                    a = j;
                }
            }
            example.exchange(num,a,i);
        }
        endTime=System.currentTimeMillis();
        System.out.printf("选择排序耗时%dms\n",endTime-startTime);
    }

}
