package com.ds.trees;

import java.util.Arrays;

public class BinarySearchTree extends BinaryTree {

	@Override
	public void insert(Comparable data) {
		// TODO Auto-generated method stub
		if (root == null)
			root = new TreeNode(data);
		else {
			insertTnode(root, new TreeNode(data));
		}

	}

	public void constructFromInorderLevelOrder(Comparable[] in,
			Comparable[] levelOrder) {
		boolean[] visited = new boolean[in.length];
		Arrays.fill(visited, false);
		root = new TreeNode(levelOrder[0]);
		visited[0] = true;
	}

	private TreeNode constructFromInorderLevelOrderUtil(TreeNode node,
                                                        Comparable[] in, Comparable[] levelOrder, boolean[] visited) {

		return node;
	}

	public void insert(Comparable data, boolean storeParent) {
		if (!storeParent)
			insert(data);
		else {

		}

	}

	protected TreeNode insertTnode(TreeNode node, TreeNode data) {
		if (node == null)
			return data;
		if (node.compareTo(data) > 0) {
			node.left = insertTnode(node.left, data);
		} else if (node.compareTo(data) < 0)
			node.right = insertTnode(node.right, data);

		return node;

	}

	public void balanceBinarySearchTree() {

	}

	public void getKthSmallest(int k) {

		int[] arr = new int[] { k };
		TreeNode res = getKthSmallestUtil(root, arr);
		if (res != null)
			System.out.println(" " + k + " smallest element is " + res.data);
		else
			System.out.println(" Element not found");
	}

	private TreeNode getKthSmallestUtil(TreeNode node, int[] k) {
		if (node == null)
			return null;
		TreeNode left = getKthSmallestUtil(node.left, k);
		k[0]--;
		if (k[0] == 0)
			return node;
		if (left != null)
			return left;
		return getKthSmallestUtil(node.right, k);

	}

}
