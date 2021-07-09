package 刷题;

import java.util.*;

class edge {
    int weight, target;

    public edge(int weight, int target) {
        this.weight = weight;
        this.target = target;
    }
}

class gp {
    LinkedList<edge>[] v;
    int[] val;

    public gp(int v) {
        this.v = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.v[i] = new LinkedList<edge>();
        }
        val = new int[v];
    }

    public void add(int a, int b, int wei) {
        v[a].add(new edge(wei, b));
        v[b].add(new edge(wei, a));
    }

    public void setVal(int v, int val) {
        this.val[v] = val;
    }
}

class Res {
    Queue<Integer> lujing;
    int weightSun;
    int len;

    public Res(Queue<Integer> lujing, int weightSun, int len) {
        this.lujing = lujing;
        this.weightSun = weightSun;
        this.len = len;
    }
}

public class 紧急救援 {
    public static void main(String[] args) {
        long sta = System.currentTimeMillis();
        Scanner s = new Scanner(System.in);
        int cityNum = s.nextInt();
        gp graph = new gp(cityNum);
        int edgeNum = s.nextInt();
        int start = s.nextInt();
        int end = s.nextInt();
        for (int i = 0; i < cityNum; i++) {
            graph.setVal(i, s.nextInt());
        }
        int n = edgeNum;
        while (n-- != 0) {
            graph.add(s.nextInt(), s.nextInt(), s.nextInt());
        }
        Queue<Integer> path = new LinkedList<>();
        LinkedList<Res> res = new LinkedList<>();
        boolean[] used = new boolean[cityNum];
        dfs(graph, start, end, path, 0, 0, res, used);
        int minlen = Integer.MAX_VALUE;
        for (int i = 0; i < res.size(); i++) {
            minlen = Math.min(res.get(i).len, minlen);
        }
        int max = 0;
        Res resout = null;
        int lennum = 0;
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).len == minlen) {
                lennum++;
                max = Math.max(max, res.get(i).weightSun);
            }
        }
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).len == minlen && max == res.get(i).weightSun) {
                resout = res.get(i);
            }
        }
        System.out.println(lennum + " " + max);
        for (int i : resout.lujing) {
            if (i == end) System.out.println(end);
            else System.out.print(i + " ");
        }
        long over = System.currentTimeMillis();
        System.out.println(over - sta);
    }


    private static void dfs(gp graph, int start, int end, Queue<Integer> path, int weightSum, int len, LinkedList<Res> res, boolean[] used) {
        path.add(start);
        weightSum += graph.val[start];
        used[start] = true;

        if (start == end) {
            res.add(new Res(new LinkedList<>(path), weightSum, len));
            path.remove(start);
            weightSum -= graph.val[start];
            used[start] = false;
            return;
        }
        for (edge i : graph.v[start]) {
            if (used[i.target]) continue;
            dfs(graph, i.target, end, path, weightSum, len + i.weight, res, used);
        }
        path.remove(start);
        weightSum -= graph.val[start];
        used[start] = false;
        return;
    }

}
