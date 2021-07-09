package Sort;

public class Insertion {
    public static void sort(Comparable[] num){
        long startTime,endTime;
        startTime=System.currentTimeMillis();
        for (int i = 1; i <num.length ; i++) {
            int ii=i;
            for (int j = i-1; j >=0 ; j--) {
                while(num[j].compareTo(num[ii])>0){
                    example.exchange(num,ii--,j);
                }
            }
        }
        endTime=System.currentTimeMillis();
        System.out.printf("插入排序耗时%dms\n",endTime-startTime);
    }
}
