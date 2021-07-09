package 刷题;

public class Calendar_dis {
    public static void main(String[] args) {
        System.out.println(day_dis(1979,12,15,2015,3,2));
    }
    @SuppressWarnings("all")
    static int day_dis(int year1, int month1, int day1,
                       int year2, int month2, int day2){
        return get_day(year2,month2,day2)-get_day(year1,month1,day1);
    }

    private static int get_day(int year, int month, int day) {
        int res=0;
        for (int i = 1970; i <year ; i++) {
            res+=365;
            if(isR(i)) res++;
        }
        int[] m={0,31,28,31,30,31,30,31,31,30,31,30,31};
        if(isR(year)) m[2]++;
        for (int i = 1; i < month; i++) {
            res+=m[i];
        }
        res+=day;
        return res;
    }
    private static boolean isR(int year){
        boolean res=false;
        if(year%4==0) res=true;
        if(year%100==0) res=false;
        if(year%400==0) res=true;
        return res;
    }

}
