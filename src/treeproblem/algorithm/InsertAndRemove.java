package treeproblem.algorithm;

import treeproblem.node.Node;

public class InsertAndRemove {

	public void insert(Node latestRoot, int data) {
		if(latestRoot == null) {
			latestRoot = new Node(data);
		}

		if(data<latestRoot.data) {
			if(latestRoot.left == null) {
				Node node = new Node(data);
				latestRoot.left = node;
			}
			else {
				insert(latestRoot.left, data);
			}
		} else {
			if(latestRoot.right == null) {
				Node node = new Node(data);
				latestRoot.right = node;
			}
			else {
				insert(latestRoot.right, data);
			}
		}
	}
	
	public void insertIterative(Node node) {
		if(node == null) {
			return;
		}
		while(node!=null) {
			if(node.data<node.data) {
				if(node.left == null) {
					node.left = node;
					break;
				} else {
					node = node.left;
				}
			} else {
				if(node.data>node.data) {
					if(node.right == null) {
						node.right = node;
						break;
					} else {
						node = node.right;
					}
				}
			}
		}
	}
	
	public boolean remove(Node latestRoot, int data) {
		Node node = new Node(data);
		boolean isExist = false; 
		if(node.data == latestRoot.data) {
			latestRoot = null;
			isExist = true;
		}

		if(node.data<latestRoot.data) {
			if(latestRoot.left == null) {
				isExist = false;
			} else {
				remove(latestRoot.left, node.data);
			}
		} else {
			if(latestRoot.right == null) {
				isExist = false;
			} else {
				remove(latestRoot.right, node.data);
			}
		}

		return isExist;
	}
}
