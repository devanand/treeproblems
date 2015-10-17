package treeproblem.algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
	
	static void topView(Node root, java.util.Map<Integer, List<Integer>> m, int level) {
		if(root == null) {
			return;
		}
//		range[0] = level>range[0]?level:range[0];
//		range[1] = level<range[1]?level:range[1];
		
		if(m.get(level) == null) {
			List <Integer> l = new LinkedList<Integer>();
			l.add(root.data);
			m.put(level, l);
		} else {
			m.get(level).add(root.data);
		}
		
		topView(root.left, m, level-1);
		topView(root.right, m, level+1);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.left.left = new Node(5);
		root.left.left.left = new Node(9);
		root.left.left.left.left = new Node(10);
		root.left.left.left.left.left = new Node(11);
		root.left.left.left.left.left.left = new Node(12);
		root.left.left.left.left.left.left.left = new Node(13);
		root.left.left.left.left.left.left.left.left = new Node(14);
		root.right = new Node(2);
		root.right.right = new Node(7);
		root.right.right.right = new Node(14);
		root.right.right.left = new Node(15);
		root.right.left = new Node(6);
		root.left.left.right = new Node(8);
		root.left.right = new Node(4);
		root.left.right.left = new Node(11);
		root.left.right.right = new Node(13);
		root.left.right.right.right = new Node(17);
		root.left.right.right.right.right = new Node(18);
		root.left.right.right.right.right.right = new Node(20);
		root.left.right.right.right.right.right.right = new Node(22);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(10);
		
		
		
		Util.printTree(Collections.singletonList(root), 1, 4);
		Map <Integer, List<Integer>> m = new HashMap<>();
		Map <Integer, List<Integer>> m1 = new HashMap<>();
		List<Integer> l = new LinkedList<>();
		l.add(root.data);
		m.put(0, l);
 		topView(root.left, m, -1);
 		topView(root.right, m1, 1);
 		
 		for(int i = -6 ;i<=5;i++) {
 			if(i == 0 ) System.out.print(root.data+" ");
 			else if(i < 0) {
 				if(m.get(i) != null) {
 					System.out.print(m.get(i).get(0)+" ");
 				} else {
 					System.out.print(m1.get(i).get(0)+" ");
 				}
 			}
 			else {
 				if(m1.get(i) != null) {
 					System.out.print(m1.get(i).get(0)+" ");
 				} else {
 					System.out.print(m.get(i).get(0)+" ");
 				}
 			}
 		}
 		System.out.println();
 		
 		System.out.println(m);
 		System.out.println(m1);
	}
}
