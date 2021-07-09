package 刷题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class CycleStringSum {
    public static void main(String[] args) {
        partition("aaa");
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        Stack<String> path=new Stack<>();
        dfs(s,path,res);
        return res;
    }
    public static void dfs(String s,Stack path,List<List<String>> res){
        if(s.length()==0) {
            res.add(new ArrayList<>(path));

            path.pop();

            return;
        }
        for(int i=0;i<s.length();i++){

            String fir=s.substring(0,i+1);
            if(isCycle(fir)) {
                path.add(fir);
                String las=s.substring(i+1,s.length());
                dfs(las,path,res);

            }

        }
        if(!path.isEmpty())path.pop();
    }
    public static boolean isCycle(String s){
        int len=s.length();
        int left=0;
        int right=len-1;
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--)) return false;
        }
        return true;
    }
}