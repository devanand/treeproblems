package treeproblem.algorithm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import treeproblem.node.Node;
import treeproblem.util.Util;

public class TreeViews {

	public void rightView(List<Node> nodes) {
		
		if(nodes == null || nodes.isEmpty()) {
			return;
		}
		
		System.out.println(nodes.get(nodes.size()-1).data);
		
		List <Node> temp = new LinkedList<Node>();
		for(Node node:nodes) {
			if(node.left != null) {
				temp.add(node.left);
			}
			
			if(node.right != null) {
				temp.add(node.right);
			}	
		}
		
		rightView(temp);
	}
	
	public void leftView(List<Node> nodes) {
		
		if(nodes == null || nodes.isEmpty()) {
			return;
		}
		
		System.out.println(nodes.get(0).data);
		
		List <Node> temp = new LinkedList<Node>();
		for(Node node:nodes) {
			if(node.left != null) {
				temp.add(node.left);
			}
			
			if(node.right != null) {
				temp.add(node.right);
			}	
		}
		
		leftView(temp);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.left.left = new Node(5);
		root.left.left.left = new Node(9);
		root.right = new Node(2);
		root.right.right = new Node(7);
		root.right.right.right = new Node(14);
		root.right.right.left = new Node(15);
		root.right.left = new Node(6);
		root.left.left.right = new Node(8);
		root.left.right = new Node(4);
		root.left.right.left = new Node(11);
		root.left.right.right = new Node(13);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(10);
		
		
		
		Util.printTree(Collections.singletonList(root), 1, new MaxLevel().maxLevel(root));
		new TreeViews().leftView(Collections.singletonList(root));
	}
}
