               package com.ds.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


               public abstract class BinaryTree {

	TreeNode root = null;

	public void getInorder() {
		System.out.println();
		inOrderTraversal(root);
	}

	public abstract void insert(Comparable data);

	private boolean find(Comparable d1, TreeNode node) {
		if (node == null)
			return false;
		if (node.data.compareTo(d1) == 0)
			return true;
		else
			return false;
	}

	public void getLeastCommonAncestor(Comparable d1, Comparable d2) {

		TreeNode lca = findLCA(root, d1, d2);
		if (lca != null)
			System.out.println("LCA of node " + d1 + " and " + d2 + " is "
					+ lca.data);
		else
			System.out.println("NO LCA Found");

	}

	private TreeNode findLCA(TreeNode node, Comparable d1, Comparable d2) {
		if (node == null)
			return null;
		if (node.data.compareTo(d1) == 0 || node.data.compareTo(d2) == 0)
			return node;
		TreeNode left_lca = findLCA(node.left, d1, d2);
		TreeNode right_lca = findLCA(node.right, d1, d2);
		if (left_lca != null && right_lca != null)
			return node;

		return (left_lca != null) ? left_lca : right_lca;
	}

	public void getDepthFirstTraversal(boolean throughstack) {

		if (root == null)
			return;
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		String path = "";
		while (!s.isEmpty()) {
			TreeNode temp = s.pop();

		}
	}

	public void getInorderbyMorris() {
		TreeNode current = root;
		TreeNode pre;
		System.out.println("Printing inorder by morris");
		while (current != null) {
			if (current.left == null) {
				System.out.print(" " + current.data);
				current = current.right;
			} else {
				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else if (pre.right == current) {
					System.out.print(" " + current.data);
					pre.right = null;
					current = current.right;
				}
			}

		}

	}

	private boolean hasNoLeftChild(TreeNode node) {

		return node.left == null;
	}

	private TreeNode getInOrderPredessor(TreeNode node) {
		if (node == null)
			return null;
		if (hasNoLeftChild(node))
			return null;

		TreeNode temp = node.left;
		while (temp.right != null)
			temp = temp.right;

		return temp;
	}

	public void getDepthFirstTraversal() {

		if (root == null)
			return;
		dfs(root, "");

	}

	private void dfs(TreeNode node, String path) {
		if (node == null) { // System.out.println(path);
			return;
		}
		path = path + " -->" + node.data;
		if (node.isLeafNode()) {
			System.out.println(path);
		}

		else {
			dfs(node.left, path);
			dfs(node.right, path);

		}

	}

	public void getBreadthFirstTraversal() {
		if (root == null)
			return;
		System.out.println();
		System.out.println("Printing getBreadthFirstTraversal");
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode temp = q.remove();
			System.out.print(" " + temp.data);
			if (temp.right != null)
				q.add(temp.right);
			if (temp.left != null)
				q.add(temp.left);

		}
	}

	public void getBreadthFirstTraversalSpiral() {
		System.out.println();
		System.out.println("Printing getBreadthFirstTraversalSpiral");
		Stack<TreeNode> current_level = new Stack<>();
		Stack<TreeNode> next_level = new Stack<>();
		boolean right_to_left = true;
		if (root != null)
			current_level.push(root);
		while (!current_level.isEmpty()) {
			TreeNode temp = current_level.pop();
			System.out.print(" " + temp.data);
			if (right_to_left) {
				if (temp.left != null)
					next_level.push(temp.left);
				if (temp.right != null)
					next_level.push(temp.right);
			} else {

				if (temp.right != null)
					next_level.push(temp.right);
				if (temp.left != null)
					next_level.push(temp.left);
			}

			if (current_level.isEmpty()) {
				right_to_left = !right_to_left;
				System.out.println(" #Printing next level");
				Stack<TreeNode> swap = new Stack<>();
				swap = current_level;
				current_level = next_level;
				next_level = swap;
			}

		}

	}

	private void inOrderTraversal(TreeNode node) {
		if (node == null)
			return;

		inOrderTraversal(node.left);
		System.out.print(" " + node.data);
		inOrderTraversal(node.right);
	}

	public void getPostOrder() {

		postOrderTraversal(root);
	}

	private void postOrderTraversal(TreeNode node) {
		if (node == null)
			return;

		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print("" + node.left);

	}

	public void getPreOrder() {

		preOrderTraversal(root);
	}

	private void preOrderTraversal(TreeNode node) {
		if (node == null)
			return;

		System.out.print("" + node.left);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);

	}

	public TreeNode searchNode(Comparable data) {
		return searchNodeUtil(root, data);
	}

	private TreeNode searchNodeUtil(TreeNode node, Comparable data) {
		if (node == null)
			return null;
		if (node.data.compareTo(data) == 0)
			return node;
		TreeNode lNode = searchNodeUtil(node.left, data);
		if (lNode == null)
			return searchNodeUtil(node.right, data);
		else
			return lNode;

	}

	public void getNodesatKUnits(int k, Comparable targetData) {
		if (root == null)
			return;
		TreeNode target = searchNode(targetData);
		if (target != null) {
			System.out.println();
			getNodesatKUnitsUtil(root, target, k);
		} else
			System.out.println("Target Node is not present");

	}

	private int getNodesatKUnitsUtil(TreeNode node, TreeNode target, int k) {
		if (node == null || target == null || k < 0)
			return -1;
		if (node == target) {
			getNodesAtKUnitsDown(node, k);
			return 0;
		}
		int dLeft = getNodesatKUnitsUtil(node.left, target, k);
		int dRight = getNodesatKUnitsUtil(node.right, target, k);
		if (dLeft != -1) {
			if (dLeft + 1 == k) {
				System.out.print(" " + node.data);

			} else {
				getNodesatKUnitsUtil(node.right, target, k - dLeft - 2);
			}
			return 1 + dLeft;
		}
		if (dRight != -1) {
			if (dRight + 1 == k) {
				System.out.print(" " + node.data);
			} else {
				getNodesatKUnitsUtil(node.left, target, k - dRight - 2);
			}
			return 1+dRight;
		}

		return -1;
	}

	private void getNodesAtKUnitsDown(TreeNode node, int k) {
		if (node == null || k < 0)
			return;
		if (k == 0) {
			System.out.print(" " + node.data);
			return;
		}
		getNodesAtKUnitsDown(node.left, k - 1);
		getNodesAtKUnitsDown(node.right, k - 1);
	}
public void printVerticalView()
{
	ArrayList<Comparable>list=new ArrayList<Comparable>();
	HashMap<Integer, ArrayList<Comparable>> map=new HashMap<Integer,ArrayList<Comparable>>();
	putDatainMap(root, 0, map);
	System.out.println(map.toString());
}
private void putDatainMap(TreeNode node, int d, HashMap<Integer,ArrayList<Comparable>> map)
{
	if(node==null)
		return;
	if(map.containsKey(d))
	{
		map.get(d).add(node.data);
	}else
	{
		ArrayList<Comparable>list=new ArrayList<Comparable>();
		list.add(node.data);
		map.put(d, list);
	}
	putDatainMap(node.left, d-1, map);
	putDatainMap(node.right, d+1, map);
}
public void getMirrorTree()
{
root=getMirrorImage(root);	
}
private TreeNode getMirrorImage(TreeNode node)
{
	if(node==null)
		return node;
	TreeNode temp=node.left;
	node.left=getMirrorImage(node.right);
	node.right=getMirrorImage(temp);
	return node;
}

public void isStructureSameAs(BinaryTree t)
{
	if(isShapeSame(root, t.root))
	{
		System.out.println("Both Treee have same structure");
	}else
	{
		System.out.println("Both tree have different shape");
	}
	
}
private boolean isShapeSame(TreeNode node1, TreeNode node2)
{
	if(node1==null&&node2!=null||node2==null&&node1!=null)
		return false;
	if(node1==null&&node2==null)
		return true;
	return isShapeSame(node1.left, node2.left)&&isShapeSame(node1.right, node2.right);
	
}
public void convertToMirrorImage()
{
	root=getMirrorImage(root);
}
public void getMaxLeaftoLeafSum()
{
	maxS=0;
	getMaxLeafSUtil(root);
	
	System.out.println(" Max leaf to leaf path is "+maxS);
	
}
public int max(int x,int y)
{
if(x>y)
	return x;
else
	return y;
}
int maxS=Integer.MIN_VALUE;
private int getMaxLeafSUtil(TreeNode node)
{
if(node==null)
	return 0;
Integer d=(Integer)node.data;
int left_sum=getMaxLeafSUtil(node.left);
int right_sum=getMaxLeafSUtil(node.right);
int curr_sum=max(left_sum, right_sum)+d;
int maxSum=left_sum+right_sum+d;
if(maxS<maxSum)
	maxS=maxSum;
return curr_sum;

}

public void constructTree()
{
	root = new TreeNode(-15);
    root.left = new TreeNode(5);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(-8);
    root.left.right = new TreeNode(1);
    root.left.left.left = new TreeNode(2);
    root.left.left.right = new TreeNode(6);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(9);
    root.right.right.right= new TreeNode(0);
    root.right.right.right.left= new TreeNode(4);
    root.right.right.right.right= new TreeNode(-1);
    root.right.right.right.right.left= new TreeNode(10);

}

public void getClosestLeafNode(int data){
	
	
}
private int getClosestDown(TreeNode node, TreeNode[] minNode){
	
	return 0;
}

}