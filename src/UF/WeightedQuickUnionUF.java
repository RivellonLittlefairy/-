package UF;

import java.util.Arrays;

public class WeightedQuickUnionUF {
    int[] id;
    int[] weigh;
    int count;

    public WeightedQuickUnionUF(int i) {
        id = new int[i];
        weigh = new int[i];
        count = i;
        for (int j = 0; j < i; j++) {
            id[j] = j;
        }
        Arrays.fill(weigh, 1);
    }

    public int find(int p) {
        int temp = p;
        while (id[p] != p) p = id[p];
        id[temp] = p;
        return p;
    }

    public void union(int p, int q) {
        int idp = find(p);
        int idq = find(q);
        if (idp == idq) return;
        if (weigh[idq] > weigh[idp]) {
            id[idp] = idq;
            weigh[idq] += weigh[idp];
        } else {
            id[idq] = idp;
            weigh[idp] += weigh[idq];
        }
        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int getCount() {
        return count;
    }
}
