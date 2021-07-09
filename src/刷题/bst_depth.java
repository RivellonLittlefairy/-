package 刷题;

import java.sql.SQLOutput;
import java.util.*;


import java.util.*;
@SuppressWarnings("ALL")
class BST {
    private class Node {
        int key;
        int ceng;
        int val;
        private Node lch, rch;
        Node(int key,int ceng,int val) {
            this.key = key;
            this.val = val;
            this.ceng = ceng;
        }
    }

    Node root;
    int maxCeng=0;
    int[] cengnum=new int[2000];

    public void put(int key){
        root=put(root,key,1);
    }

    private Node put(Node node, int key,int ceng) {
        if(node==null) {
            cengnum[ceng]++;
            maxCeng=Math.max(maxCeng,ceng);
            return new Node(key,ceng,1);
        }
        if(node.key>key) node.lch=put(node.lch,key,ceng+1);
        else if(node.key<key) node.rch=put(node.rch,key,ceng+1);
        else {
            node.val++;
            cengnum[node.ceng]++;

        }
        return node;
    }
    public int get(){
        return cengnum[maxCeng]+cengnum[maxCeng-1];
    }
}
public class bst_depth{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int num=s.nextInt();
        int ans[]=new int[2000];
        BST tree=new BST();
        int max1=1;
        while(num--!=0){
            tree.put(s.nextInt());
        }
        int res=tree.get();
        System.out.println(res);
    }
}