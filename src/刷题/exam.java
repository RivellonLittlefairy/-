package 刷题;

import java.util.HashSet;
import java.util.Set;

public class exam {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2};
        System.out.println(Solution.firstMissingPositive(new int[]{1,2,0}));
    }
}
class Solution {
    public static int firstMissingPositive(int[] nums) {
        final int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]<len&&nums[i]>0){
                if(nums[i]==nums[nums[i]]) continue;
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
                i--;
            }
        }
        for(int i=0;i<len;i++){
            if(nums[i]!=i+1) return i;
        }
        return len+1;
    }
}
class TreeNode {
         int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
           TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
