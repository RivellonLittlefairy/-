package Tree;

public class example {
    public static void main(String[] args) {
        BST<Integer, Integer> tree=new BST<Integer, Integer>();
        tree.put(2,1);
        tree.put(1,1);
        tree.put(4,1);
        tree.put(3,1);
        tree.put(5,1);

        System.out.println(tree.root);

    }
}
