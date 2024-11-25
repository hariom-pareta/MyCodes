 /**
  * Definition for a binary tree node.
  * public class TreeNode {
  *     int val;
  *     TreeNode left;
  *     TreeNode right;
  *     TreeNode(int x) { val = x; }
  * }
  */
 class Solution {
 	private int sum = 0;
 	public int sumNumbers(TreeNode root) {
 		if(root == null) return 0;
 		getNumber(root, 0);
 		return this.sum;
 	}
 	private void getNumber(TreeNode node, int num){
 		int cur = num * 10 + node.val;
 		if(node.left == null && node.right == null){
 			sum += cur;
 			return;
 		}
 		if(node.left != null) getNumber(node.left, cur);
 		if(node.right != null) getNumber(node.right, cur);
 	}
 }