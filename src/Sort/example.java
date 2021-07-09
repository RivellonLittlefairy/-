package Sort;

public class example {
    public static void main(String[] args) {


        Comparable[] num,nums;
        num=new Comparable[100000];
        for (int i = 0; i < num.length; i++) {
            num[i]=Math.random()*Math.random()*100;
        }
        nums=num.clone();
        HeapSort.sort(nums);
        Comparable[] A=num.clone();
        Quick.sort(A);
        Merge.sort(A);
        System.out.println(compare(nums, A));


    }
    public static void exchange(Comparable[] num, int a, int b){
        Comparable temp=num[a];
        num[a]=num[b];
        num[b]=temp;
    }
    public static boolean compare(Comparable[] a,Comparable[] b){
        for (int i = 0; i < a.length; i++) {
            if(a[i].compareTo(b[i])!=0) return false;
        }
        return true;
    }
}
