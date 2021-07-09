import java.util.LinkedList;

public class 最短路径 {
}
class DirectedEdge{
    int from;
    int to;
    int weight;

    public DirectedEdge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
class DirectedEdgeGraph{
    int edgeNum=0;
    LinkedList<DirectedEdge>[] v;

    DirectedEdgeGraph(int num){
        v=new LinkedList[num];
        for (int i = 0; i < num; i++) {
            v[i]=new LinkedList<>();
        }
    }
    public void add(int a,int b,int wei){
        v[a].add(new DirectedEdge(a,b,wei));
        edgeNum++;
    }
}


