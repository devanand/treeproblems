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
	
	static void topViewFinder(Node root, java.util.Map<Integer, List<Integer>> m, int level, int range[]) {
		if(root == null) {
			return;
		}
		range[0] = level>range[0]?level:range[0];
		range[1] = level<range[1]?level:range[1];
		
		if(m.get(level) == null) {
			List <Integer> l = new LinkedList<Integer>();
			l.add(root.data);
			m.put(level, l);
		} else {
			m.get(level).add(root.data);
		}
		
		topViewFinder(root.left, m, level-1, range);
		topViewFinder(root.right, m, level+1, range);
	}
	
	static void topView(Node root) {
		Map <Integer, List<Integer>> leftMap = new HashMap<>();
		Map <Integer, List<Integer>> rightMap = new HashMap<>();
		List<Integer> l = new LinkedList<>();
		l.add(root.data);
		leftMap.put(0, l);
		
		int range[] = new int[2];
		range[0] = Integer.MIN_VALUE;
		range[1] = Integer.MAX_VALUE;
 		topViewFinder(root.left, leftMap, -1, range);
 		topViewFinder(root.right, rightMap, 1, range);
 		
 		for(int i = range[1] ;i<=range[0];i++) {
 			if(i == 0 ) System.out.print(root.data+" ");
 			else if(i < 0) {
 				if(leftMap.get(i) != null) {
 					System.out.print(leftMap.get(i).get(0)+" ");
 				} else {
 					if(rightMap.get(i) != null) 
 						System.out.print(rightMap.get(i).get(0)+" ");
 				}
 			}
 			else {
 				if(rightMap.get(i) != null) {
 					System.out.print(rightMap.get(i).get(0)+" ");
 				} else 
 					if(leftMap.get(i) != null) {
 						System.out.print(leftMap.get(i).get(0)+" ");
 				}	
 			}
 		}
 		System.out.println();
 		System.out.println(leftMap);
 		System.out.println(rightMap);
	}
	
	
	static void bottomView(Node root) {
		Map <Integer, List<Integer>> leftMap = new HashMap<>();
		Map <Integer, List<Integer>> rightMap = new HashMap<>();
		List<Integer> l = new LinkedList<>();
		l.add(root.data);
		leftMap.put(0, l);
		
		int range[] = new int[2];
		range[0] = Integer.MIN_VALUE;
		range[1] = Integer.MAX_VALUE;
 		topViewFinder(root.left, leftMap, -1, range);
 		topViewFinder(root.right, rightMap, 1, range);
 		
 		for(int i = range[1] ;i<=range[0];i++) {
 			
	 		if(i == 0 ){
	 			if(rightMap.get(i) != null) {
	 				int rightSize = rightMap.get(i).size()-1;
					System.out.print(rightMap.get(i).get(rightSize)+" ");
	 			} else if(leftMap.get(i)!=null) {
	 				int leftSize = leftMap.get(i).size()-1;
 					System.out.print(leftMap.get(i).get(leftSize)+" ");
	 			}
 			}
	 				
	 		else if(i < 0) {
	 				if(leftMap.get(i) != null) {
	 					int leftSize = leftMap.get(i).size()-1;
	 					System.out.print(leftMap.get(i).get(leftSize)+" ");
	 				} else {
	 					if(rightMap.get(i) != null) {
	 						int rightSize = rightMap.get(i).size()-1;
	 						System.out.print(rightMap.get(i).get(rightSize)+" ");
	 					}
	 				}
	 			}
			else if(i>0) {
				if(rightMap.get(i) != null) {
					int rightSize = rightMap.get(i).size()-1;
					System.out.print(rightMap.get(i).get(rightSize)+" ");
				} else 
					if(leftMap.get(i) != null) {
						int leftSize = leftMap.get(i).size()-1;
						System.out.print(leftMap.get(i).get(leftSize)+" ");
				}	
			}
 		}
 		System.out.println();
 		System.out.println(leftMap);
 		System.out.println(rightMap);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.left.left = new Node(5);
		
		root.right = new Node(2);
		root.right.right = new Node(7);
		root.right.left = new Node(6);
		root.left.right = new Node(4);
		
		Util.printTree(Collections.singletonList(root), 1, 3);
		bottomView(root);
		
	}
}
