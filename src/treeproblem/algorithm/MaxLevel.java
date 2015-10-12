package treeproblem.algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
	
	
}
