package UF;

public class example2 {
    public static void main(String[] args) {
        int[][] a={{1,2},{2,3},{3,4},{1,4},{1,5}};
        Solution2.findRedundantConnection(a);
    }
}
class Solution2 {
    public static int[] findRedundantConnection(int[][] edges) {
        int len=edges.length;
        WeightedQuickUnionUF uf=new WeightedQuickUnionUF(len);
        int num=len;
        int res[]=new int[2];
        for(int i=0;i<len;i++){
            uf.union(edges[i][0]-1,edges[i][1]-1);
            if(uf.getCount()==num){
                res=edges[i];
            }else{
                num--;
            }
        }
        return res;



    }
}
