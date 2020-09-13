package com.ds.trees;

public class TreeNode implements Comparable<TreeNode>{
	public TreeNode left = null;
	public TreeNode right = null;
	public TreeNode nextRight=null;
	public Comparable data;
	boolean isVisited=false;
	TreeNode parent=null;
	public int height=0;
	public TreeNode(Comparable data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.left=null;
		this.right=null;
	}

	@Override
	public int compareTo(TreeNode o) {
		// TODO Auto-generated method stub
		return this.data.compareTo(o.data);
		
	}
public boolean isLeafNode()
{
if(this.left==null&&this.right==null)
	return true;
else
	return false;
}
	
}
