               package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;



public abstract class BinaryTree {

	Tnode root = null;

	public void getInorder() {
		System.out.println();
		inOrderTraversal(root);
	}

	public abstract void insert(Comparable data);

	private boolean find(Comparable d1, Tnode node) {
		if (node == null)
			return false;
		if (node.data.compareTo(d1) == 0)
			return true;
		else
			return false;
	}

	public void getLeastCommonAncestor(Comparable d1, Comparable d2) {

		Tnode lca = findLCA(root, d1, d2);
		if (lca != null)
			System.out.println("LCA of node " + d1 + " and " + d2 + " is "
					+ lca.data);
		else
			System.out.println("NO LCA Found");

	}

	private Tnode findLCA(Tnode node, Comparable d1, Comparable d2) {
		if (node == null)
			return null;
		if (node.data.compareTo(d1) == 0 || node.data.compareTo(d2) == 0)
			return node;
		Tnode left_lca = findLCA(node.left, d1, d2);
		Tnode right_lca = findLCA(node.right, d1, d2);
		if (left_lca != null && right_lca != null)
			return node;

		return (left_lca != null) ? left_lca : right_lca;
	}

	public void getDepthFirstTraversal(boolean throughstack) {

		if (root == null)
			return;
		Stack<Tnode> s = new Stack<>();
		s.push(root);
		String path = "";
		while (!s.isEmpty()) {
			Tnode temp = s.pop();

		}
	}

	public void getInorderbyMorris() {
		Tnode current = root;
		Tnode pre;
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

	private boolean hasNoLeftChild(Tnode node) {

		return node.left == null;
	}

	private Tnode getInOrderPredessor(Tnode node) {
		if (node == null)
			return null;
		if (hasNoLeftChild(node))
			return null;

		Tnode temp = node.left;
		while (temp.right != null)
			temp = temp.right;

		return temp;
	}

	public void getDepthFirstTraversal() {

		if (root == null)
			return;
		dfs(root, "");

	}

	private void dfs(Tnode node, String path) {
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
		Queue<Tnode> q = new LinkedList<Tnode>();
		q.add(root);
		while (!q.isEmpty()) {
			Tnode temp = q.remove();
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
		Stack<Tnode> current_level = new Stack<>();
		Stack<Tnode> next_level = new Stack<>();
		boolean right_to_left = true;
		if (root != null)
			current_level.push(root);
		while (!current_level.isEmpty()) {
			Tnode temp = current_level.pop();
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
				Stack<Tnode> swap = new Stack<>();
				swap = current_level;
				current_level = next_level;
				next_level = swap;
			}

		}

	}

	private void inOrderTraversal(Tnode node) {
		if (node == null)
			return;

		inOrderTraversal(node.left);
		System.out.print(" " + node.data);
		inOrderTraversal(node.right);
	}

	public void getPostOrder() {

		postOrderTraversal(root);
	}

	private void postOrderTraversal(Tnode node) {
		if (node == null)
			return;

		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print("" + node.left);

	}

	public void getPreOrder() {

		preOrderTraversal(root);
	}

	private void preOrderTraversal(Tnode node) {
		if (node == null)
			return;

		System.out.print("" + node.left);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);

	}

	public Tnode searchNode(Comparable data) {
		return searchNodeUtil(root, data);
	}

	private Tnode searchNodeUtil(Tnode node, Comparable data) {
		if (node == null)
			return null;
		if (node.data.compareTo(data) == 0)
			return node;
		Tnode lNode = searchNodeUtil(node.left, data);
		if (lNode == null)
			return searchNodeUtil(node.right, data);
		else
			return lNode;

	}

	public void getNodesatKUnits(int k, Comparable targetData) {
		if (root == null)
			return;
		Tnode target = searchNode(targetData);
		if (target != null) {
			System.out.println();
			getNodesatKUnitsUtil(root, target, k);
		} else
			System.out.println("Target Node is not present");

	}

	private int getNodesatKUnitsUtil(Tnode node, Tnode target, int k) {
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

	private void getNodesAtKUnitsDown(Tnode node, int k) {
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
private void putDatainMap(Tnode node,int d,HashMap<Integer,ArrayList<Comparable>> map)
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
private Tnode getMirrorImage(Tnode node)
{
	if(node==null)
		return node;
	Tnode temp=node.left;
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
private boolean isShapeSame(Tnode node1,Tnode node2)
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
private int getMaxLeafSUtil(Tnode node)
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
	root = new Tnode(-15);
    root.left = new Tnode(5);
    root.right = new Tnode(6);
    root.left.left = new Tnode(-8);
    root.left.right = new Tnode(1);
    root.left.left.left = new Tnode(2);
    root.left.left.right = new Tnode(6);
    root.right.left = new Tnode(3);
    root.right.right = new Tnode(9);
    root.right.right.right= new Tnode(0);
    root.right.right.right.left= new Tnode(4);
    root.right.right.right.right= new Tnode(-1);
    root.right.right.right.right.left= new Tnode(10);

}

public void getClosestLeafNode(int data){
	
	
}
private int getClosestDown(Tnode node,Tnode[] minNode){
	
	return 0;
}

}