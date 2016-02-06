package treeproblem.algorithm;

import treeproblem.node.Node;

public class ReversePostOrder {

	static void arrayToPostOrder(int a[],Node root, int start, int end) {
		
		if(end<start) {
			return;
		}
		
		root.right = new Node(a[end]);
		int pivot = start+((end-start)/2);
		root.left = new Node(a[pivot]);
		
		arrayToPostOrder(a, root.left, start, pivot-1);
		arrayToPostOrder(a, root.right, pivot+1, end-1);
	}
}
