package treeproblem.algorithm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import treeproblem.node.Node;
import treeproblem.util.Util;

public class MaxLevel {

	public int maxLevel(Node node) {
		if(node == null) return 0;
		int left = maxLevel(node.left);
		int right = maxLevel(node.right);
		return Math.max(left, right)+1;
	}
	
	public int minLevel(Node node) {
		if(node == null ) return Integer.MAX_VALUE;
		if(node.left == null && node.right == null) return 1;
		int left = minLevel(node.left);
		int right = minLevel(node.right);
		return Math.min(left, right)+1;
	}
	
	public static int minLevelIteration(List<Node>nodes) {
		int i = 0;
		while(nodes!=null || !nodes.isEmpty()) {
			i++;
			List <Node> temp = new LinkedList<Node>();
			for(Node node:nodes) {
				if(node.left == null && node.right == null) return i;
				if(node.left != null) {
					temp.add(node.left);
				}
				if(node.right != null) {
					temp.add(node.right);
				}
				nodes = temp;
			}
		}
		return i;
	}
	
	public static int minLevelIteration(List<Node> nodes, int minLevel) {
		
		if(nodes == null || nodes.isEmpty()) return minLevel;
		
		minLevel++;
		boolean isEmptyTree = false;
		List<Node> temp = new LinkedList<Node>();
		for(Node node:nodes) {
			if(node.left == null && node.right == null) {
				isEmptyTree = true;
				break;
			}
			if(node.left != null) {
				temp.add(node.left);
			}
			if(node.right != null) {
				temp.add(node.right);
			}
		}
		if(isEmptyTree) temp = null;
		return minLevelIteration(temp, minLevel);
	}
	
	public static int maxLevelIteration(List<Node> nodes, int maxLevel) {
		
		if(nodes == null || nodes.isEmpty()) return maxLevel;
		
		maxLevel++;
		List<Node> temp = new LinkedList<Node>();
		for(Node node:nodes) {
//			if(node.left == null && node.right == null) {
//				isEmptyTree = true;
//				break;
//			}
			if(node.left != null) {
				temp.add(node.left);
			}
			if(node.right != null) {
				temp.add(node.right);
			}
		}
		return maxLevelIteration(temp, maxLevel);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.right = new Node(5);
		root.left.left.left = new Node(6);
		Util.printTree(Collections.singletonList(root), 1, new MaxLevel().maxLevel(root));
		System.out.println(maxLevelIteration(Collections.singletonList(root), 0));
	}
}
