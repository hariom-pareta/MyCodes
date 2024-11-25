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
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode cur = root;
        if(root.left != null){
            cur = cur.left;
            while(cur.right != null)
                cur = cur.right;
            cur.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }
}