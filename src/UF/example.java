package UF;

import java.util.HashMap;

public class example {
    public static void main(String[] args) {
        int[] source = {1, 2, 3, 4}, target = {2, 1, 4, 5};
        int[][] allowedSwaps = {{0, 1}, {2, 3}};
        Solution.minimumHammingDistance(source, target, allowedSwaps);
    }
}

class Solution {
    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int res = 0;
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(source.length);
        for (int i = 0; i < allowedSwaps.length; i++) {
            uf.union(allowedSwaps[i][0], allowedSwaps[i][1]);
        }
        HashMap<Integer, HashMap<Integer, Integer>> out = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            if (!out.containsKey(uf.find(i))) {
                out.put(uf.find(i), new HashMap<Integer, Integer>());
            }
            HashMap<Integer, Integer> temp = out.get(uf.find(i));
            if (!temp.containsKey(source[i])) {
                temp.put(source[i], 1);
            } else {
                int num = temp.remove(source[i]);
                temp.put(source[i], ++num);
            }
        }
        for (int i = 0; i < target.length; i++) {
            HashMap<Integer, Integer> temp = out.get(uf.find(i));
            if (temp.containsKey(target[i])) {
                int num = temp.remove(target[i]);
                if (num != 1) temp.put(target[i], --num);
            } else {
                res++;
            }
        }
        return res;
    }
}
