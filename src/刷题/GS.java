package 刷题;

import java.util.*;
public class GS {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int[][] manlove = new int[30][30];
        int[][] womanlove = new int[30][30];
        int[] manname = new int[30];
        int[] womanname = new int[30];
        int[] manpoint = new int[30];
        int[] womanpoint = new int[30];
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0) {
            queue.clear();
            int coupleNum = s.nextInt();
            for (int i = 0; i < coupleNum; i++) {
                manname[i] = s.next().charAt(0) - 'a';
                queue.add(manname[i]);
            }
            for (int i = 0; i < coupleNum; i++) {
                womanname[i] = s.next().charAt(0) - 'A';
            }
            String line;
            for (int i = 0; i < coupleNum; i++) {
                line = s.next();
                for (int j = 0; j < coupleNum; j++) {
                    manlove[i][j] = line.charAt(j + 2) - 'A';
                }
            }
            for (int i = 0; i < coupleNum; i++) {
                line = s.next();
                for (int j = 0; j < coupleNum; j++) {
                    womanlove[i][j] = line.charAt(j + 2) - 'a';
                }
            }
            for (int i = 0; i < coupleNum; i++) {
                manpoint[i] = womanpoint[i] = -1;
            }
            while (!queue.isEmpty()) {
                int man = queue.remove();
                if (manpoint[man] == -1) {
                    manpoint[man] = 0;
                }
                int woman = manlove[man][manpoint[man]];
                data(man, woman, queue, manlove, womanlove, manpoint, womanpoint);

            }
            for (int i = 0; i < coupleNum; i++) {
                int woman = manlove[i][manpoint[i]-1];
                System.out.printf("%c %c\n", manname[i] + 'a', woman + 'A');
            }
            System.out.println();
        }

    }

    public static void data(int thisman, int thiswoman, Queue<Integer> queue, int[][] manlove, int[][] womanlove, int[] manPoint, int[] womanChoose) {
        if (womanChoose[thiswoman] == -1) {
            womanChoose[thiswoman] = thisman;
            manPoint[thisman]++;
            return;
        }
        for (int i : womanlove[thiswoman]) {
            if (i == womanChoose[thiswoman]) {
                queue.add(thisman);
                manPoint[thisman]++;
                return;
            }
            if (i == thisman) {
                queue.add(womanChoose[thiswoman]);
                womanChoose[thiswoman] = thisman;
                manPoint[thisman]++;
                return;
            }
        }
    }
}