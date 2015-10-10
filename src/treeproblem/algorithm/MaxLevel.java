package treeproblem.algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import treeproblem.node.Node;

public class MaxLevel {

	public int maxLevel(Node node) {
		if(node == null) return 0;
		int left = maxLevel(node.left);
		int right = maxLevel(node.right);
		return Math.max(left, right)+1;
	}
	
}
