package Graph;
import UF.WeightedQuickUnionUF;

import java.util.LinkedList;
import java.util.Queue;

public class Search {
    Graph graph;
    int s;
    public Search(Graph graph,int s){
        this.s=s;
        this.graph=graph;
    }
/*  并查集解决搜索问题，遍历图中每个节点，union该节点和该节点直接指向的节点
    public boolean marked(int v){
        WeightedQuickUnionUF uf=new WeightedQuickUnionUF(graph.getV());
        for (int i = 0; i < graph.getV(); i++) {
            for(int j:graph.adj(i)){
                uf.union(j,i);
            }
        }
        return uf.connected(v,s);
    }

 */
    public boolean marked(int v){
        DFS dfs=new DFS(graph,s);
        return dfs.search(v);
    }
    public int count(){
        return 0;
    }
}
class DFS{
    Graph graph;
    int s;
    int[] marked;
    DFS(Graph graph,int s){
        this.graph=graph;
        marked=new int[graph.getV()];
        this.s=s;
    }
    public boolean search(int v){
        if(v==s) return true;
        marked[v]=1;
        for(int i:graph.adj(v)){
            if(marked[i]==1) continue;
            return search(i);
        }
        return false;
    }
}
class BFS{
    Graph graph;
    int s;
    int[] marked;
    Queue<Integer> queue;
    BFS(Graph graph,int s){
        this.graph=graph;this.s=s;
        marked=new int[graph.getV()];
        queue=new LinkedList<>();

    }
    public boolean search(int v){
        queue.add(s);
        while(!queue.isEmpty()){
            int temp=queue.remove();
            if(temp==v) return true;
            marked[temp]=1;
            for(int i:graph.adj(temp)){
                if(marked[i]==0){
                    queue.add(i);
                }
            }
        }
        return false;
    }

}

