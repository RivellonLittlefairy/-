package Graph;
import Bag.Bag;

import java.util.Iterator;
//此为用背包实现的图，不能删除顶点和边，同时允许平行边的存在
// 因为数组无法扩容，背包中没有提供删除元素的方法且允许值重复
public class Graph implements Cloneable{
    private Bag<Integer>[] V;
    private int edge;
    public Graph(int n){
        V=new Bag[n];
        for (int i = 0; i < n; i++) {
            V[i]=new Bag<Integer>();
        }
    }
    public int getV(){
        return V.length;
    }
    public int getEdge(){
        return edge;
    }
    public void addEdge(int v,int w){
        V[v].add(w);
        V[w].add(v);
        edge++;
    }
    public Iterable<Integer> adj(int v){
        return V[v];
    }


}
