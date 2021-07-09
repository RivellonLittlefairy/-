package UF;

public class UnionFind {
    int id[];
    int count;

    UnionFind(int i) {
        id = new int[i];
        count = i;
        for (int j = 0; j < i; j++) {
            id[j] = j;
        }
    }

    public void union(int p, int q) {
        int idp = id[p];
        int idq = id[q];
        if (idp == idq) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == idq) id[i] = idp;
        }
        count--;
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public int getCount() {
        return count;
    }
}
