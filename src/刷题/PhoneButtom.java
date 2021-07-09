package 刷题;

import java.util.*;

class PhoneButtom {
    public static void main(String[] args) {
        letterCombinations("23");
    }
    public  static List<String> letterCombinations(String digits) {
        HashMap<Integer,List<Character>> map=new HashMap<>();
        for(int i=0;i<=5;i++){
            List<Character> lis=new LinkedList<>();
            lis.add((char)(i*3+'a'));
            lis.add((char)(i*3+'b'));
            lis.add((char)(i*3+'c'));
            if(i==5) lis.add((char)(i*3+'d'));
            map.put(i+2,lis);
        }
        List<Character> lis=new LinkedList<>();
        lis.add('t');lis.add('u');lis.add('v');map.put(8,lis);
        List<Character> lis2=new LinkedList<>();
        lis2.add('w');lis2.add('x');lis2.add('y');lis2.add('z');map.put(9,lis2);
        List<String> res=new LinkedList<>();
        List<Character> path=new LinkedList<Character>();
        int i=0;
        dfs(i,map,res,digits,path);
        return res;
    }

    private  static void dfs(int i,HashMap<Integer, List<Character>> map, List<String> res, String digits,List<Character> path) {
        if(i==digits.length()){
            char[] re=new char[digits.length()];
            LinkedList<Character> path2=new LinkedList<Character>(path);
            while(!path2.isEmpty()){
                int ii=path2.size();
                re[ii-1]=path2.remove(path2.size()-1);
            }
            res.add(new String(re));
            return;
        }
        int num=digits.charAt(i)-48;
        List<Character> lis=map.get(num);
        for(Character ar:lis){
            path.add(ar);
            dfs(i+1,map,res,digits,path);
            path.remove(path.size()-1);
        }
    }
}
