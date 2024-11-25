 class Solution {
 	public Node connect(Node root) {
 		recursion(root);
 		return root;
 	}
 	private void recursion(Node node){
 		if(node == null) return;
 		Node dummy = new Node();
 		Node cur = dummy;
 		while(node != null){	// for current level.
 			if(node.left != null){	// append all child nodes.
 				cur.next = node.left;
 				cur = cur.next;
 			}
 			if(node.right != null){
 				cur.next = node.right;
 				cur = cur.next;
 			}
 			node = node.next;
 		}
 		recursion(dummy.next);	// recursion to next level.
 	}
 }