package treeproblem.algorithm;

import treeproblem.node.Node;

public class IsBst {

	public static boolean isBst(Node root, int min, int max) { 
		if(root == null) return true;

		if(root.data<min || root.data>max) {
			return false;
		}

		boolean x = isBst(root.left, min, root.data);
		boolean y = isBst(root.right, root.data, max); 

		return x && y;
	}
	
	public static boolean isBst(Node root) {
		if(root == null) return true;
		if(root.left !=null) {
			if(root.left.data>root.data) {
				return false;
			}
		}
		if(root.right!=null) {
			if(root.right.data<root.data) {
				return false;
			}
		}
		
		return isBst(root.left) && isBst(root.right);
	}
}
