package treeproblem.algorithm;

import java.util.Collections;

import treeproblem.node.Node;
import treeproblem.util.Util;

public class IsSubTree {

	public boolean isSubTree(Node root1, Node root2) {
		if(root2 == null) {
			return true;
		} 
		
		if(root1 == null) {
			return false;
		}
		
		if(root1.data == root2.data) {
			return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
		} else {
			return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
		}
	}
	
//	public static void main(String[] args) {
//		Node root1 = new Node(2);
//		root1.left = new Node(1);
//		root1.right = new Node(3);
//		root1.right.right = new Node(4);
//		
//		Node root2 = new Node(3);
//		root2.right = new Node(5);
//		
//		Util.printTree(Collections.singletonList(root1), 1, 3);
//		Util.printTree(Collections.singletonList(root2), 1, 2);
//		
//		System.out.println(new IsSubTree().isSubTree(root1, root2));
//		
//	}
}
