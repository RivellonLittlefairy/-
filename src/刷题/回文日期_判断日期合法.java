package 刷题;

import java.util.*;
public class 回文日期_判断日期合法 {
    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        boolean findhui=false;
        while(true) {
            n++;
            if(!buhefa(n)) continue;
            if(ishui(n)) {
                if(!findhui) {
                    findhui=true;
                    System.out.println(n);
                }
                if(isAB(n)) {
                    System.out.println(n);
                    return;
                }

            }
        }
    }

    private static boolean buhefa(int n) {
        String s = Integer.toString(n);
        int year = Integer.parseInt(s.substring(0, 4));
        int month = Integer.parseInt(s.substring(4, 6));
        int day = Integer.parseInt(s.substring(6, 8));
        if (month <= 0 || month > 12) {
            return false;
        }
        if (day <= 0) {
            return false;
        }
        switch (month) {
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    if (day > 29) {
                        return false;
                    }
                } else {
                    if (day > 28) {
                        return false;
                    }
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) {
                    return false;
                }
                break;
            default:
                if (day > 31) {
                    return false;
                }
                break;
        }
        return true;

    }

    private static boolean isAB(int n) {
        // TODO Auto-generated method stub
        String str=n+"";
        char[] ar=str.toCharArray();
        if(ar[0]==ar[2]&&ar[1]==ar[3]) {
            if(ar[0]!=ar[1]) return true;
        }
        return false;
    }

    private static boolean ishui(int n) {
        // TODO Auto-generated method stub
        String str=n+"";
        char[] ar=str.toCharArray();
        for(int i=0;i<4;i++) {
            if(ar[i]!=ar[7-i]) return false;
        }
        return true;
    }
}