package 刷题;

import java.util.*;
class Main{
    public static void main(String[] args) {
        reverseWords("a good   example");
    }
    public static String reverseWords(String s) {
        String[] str=s.trim().split("\\s+");
        StringBuilder res= new StringBuilder();
        for(int i=str.length-1;i>-1;i--){
            res.append(str[i]).append(" ");
        }
        res.toString().trim();
        String resout=res.substring(0,res.length()-1);
        System.out.println(resout);
        return res.toString();
    }
}