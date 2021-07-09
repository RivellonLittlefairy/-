package 刷题;

import java.util.HashMap;

class MinStack {
    class node {
        node next;
        int val;
        node front;

        public node() {
        }

        public node(int val) {
            this.val = val;
        }

        public node(node front, int val) {
            this.front = front;
            this.val = val;
        }
    }

    int min = Integer.MAX_VALUE;
    HashMap<Integer,Integer> map=new HashMap<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    node head = new node();
    node temp = head;

    public void push(int val) {
        if(map.containsKey(val)){
            int n=map.get(val);
            map.put(val,++n);
        }
        else map.put(val,1);
        min = Math.min(min, val);
        temp.next = new node(temp,val);
        temp = temp.next;
    }

    public void pop() {
        if (head == temp||temp==null) return;
        int v=temp.val;

        if(map.get(v)==1) map.remove(v);
        else map.put(v,map.get(v)-1);
        min=Integer.MAX_VALUE;
        for(int i: map.keySet()){
            min=Math.min(min,i);
        }
        node n=temp.front;
        temp=null;
        temp=n;



    }

    public int top() {
        if (temp == null) return 0;
        return temp.val;
    }

    public int getMin() {
        if (head == temp) return 0;
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

