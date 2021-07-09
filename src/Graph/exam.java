package Graph;

import java.util.Iterator;
@SuppressWarnings("all")
public class exam {
    public static void main(String[] args) {
        Graph g=new Graph(7);
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(5,6);
        Search a=new Search(g,0);

        System.out.println(a.marked(1));
        System.out.println(a.marked(2));
        System.out.println(a.marked(3));
        System.out.println(a.marked(4));
        System.out.println(a.marked(5));


    }
}
