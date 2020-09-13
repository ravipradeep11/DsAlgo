package com.ds.trees;

public class AvlTree extends BinarySearchTree {

	private static final int LEFT_HEAVY = -1;
	private static final int BALANCED = 0;
	private static final int RIGHT_HEAVY = 1;

	@Override
	public void insert(Comparable data) {
		// TODO Auto-generated method stub
		root = insert(root, data);
		super.insert(data);
	}

	public int max(int h1, int h2) {
		if (h1 > h2)
			return h1;
		else
			return h2;
	}

	private TreeNode insert(TreeNode node, Comparable data) {

		if (node == null)
			return new TreeNode(data);
		if (node.data.compareTo(data) > 0)
			node.left = insert(node.left, data);
		else
			node.right = insert(node.right, data);

		node.height = max(height(node.left), height(node.right)) + 1;
		int balance=getBalance(node);
		if(balance==LEFT_HEAVY&&node.data.compareTo(data)>0)
		{
			return rightRotate(node);
		}
		else if(balance==LEFT_HEAVY&&node.data.compareTo(data)<0)
		{
			node.left=leftRotate(node.left);
			return rightRotate(node);
		}

		return node;

	}

	private int getBalance(TreeNode node)
	{
		if(node==null)
			return BALANCED;
		int diff=height(node.right)-height(node.left);
		if(diff>0)
			return RIGHT_HEAVY;
		else if(diff<0)
			return LEFT_HEAVY;
		else
			return BALANCED;
		
			
	}
	private TreeNode leftRotate(TreeNode node) {
		return node;
	}

	private TreeNode rightRotate(TreeNode node) {
		return node;
	}

	private int height(TreeNode node) {
		if (node == null)
			return 0;
		else
			return node.height;
	}
}
