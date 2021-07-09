package Tree;

public class BST<Key extends Comparable<Key>, Value> {
    Node root;

    private class Node {
        private Key key;
        private Value value;
        private int weight = 0;
        private Node lch, rch;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public int getWeight() {
        return root.weight;
    }

    public Value find(Key key) {
        return find(root, key);
    }

    public Value find(Node node, Key key) {
        if (node == null) return null;
        if (node.key.compareTo(key) == 0) return node.value;
        else if (key.compareTo(node.key) < 0) return find(node.lch, key);
        else return find(node.rch, key);
    }

    public Node findNode(Node node, Key key) {
        if (node == null) return null;
        if (node.key.compareTo(key) == 0) return node;
        else if (key.compareTo(node.key) < 0) return findNode(node.lch, key);
        else return findNode(node.rch, key);
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value);
        int num = key.compareTo(node.key);
        if (num > 0) node.rch = put(node.rch, key, value);
        if (num < 0) node.lch = put(node.lch, key, value);
        else node.value = value;
        return node;

    }


}
