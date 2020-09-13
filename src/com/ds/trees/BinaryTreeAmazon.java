package com.ds.trees;

public class BinaryTreeAmazon extends BinarySearchTree {
	
	
	public void findLeastCommonAncestor(Comparable data1,Comparable data2)
	{
		boolean[] v1=new boolean[]{false};
		boolean[] v2=new boolean[]{false};
		TreeNode lca=findLCAUtil(root,data1,data2,v1,v2);
		if(lca!=null){
			if(v1[0]&&v2[0]||v1[0]&&findinTree(lca, data2)||v2[0]&&findinTree(lca,data1))
				System.out.println(" LCA is "+lca.data);
			else
				System.out.println("One of the element is not found in the tree");
		}else{
			System.out.println("None of the elements are found in the tree");
		}
		
	}
	
	private TreeNode findLCAUtil(TreeNode node, Comparable data1, Comparable data2, boolean[]v1, boolean[] v2)
	{
		if(node==null)
			return null;
		TreeNode lca_left,lca_right;
		if(node.data.compareTo(data1)==0)
		{
			v1[0]=true;
			return node;
		}
		if(node.data.compareTo(data2)==0)
		{
			v2[0]=true;
			return node;
		}
		lca_left=findLCAUtil(node.left,data1,data2,v1,v2);
		lca_right=findLCAUtil(node.right,data1,data2,v1,v2);
		if(lca_left!=null&&lca_right!=null)
			return node;
		if(lca_left!=null)
			return lca_left;
		else
			return lca_right;
		
		
		
	}	
	private boolean findinTree(TreeNode node, Comparable data){
		
		if(node==null)
			return false;
		if(node.data.compareTo(data)==0)
			return true;
		return findinTree(node.left,data)||findinTree(node.right,data);
	}
	public void convertToSumTree()
	{
		getSumGreaterUtil(root, new int[]{0});
	}
	private void getSumGreaterUtil(TreeNode node, int[] sumGreater){
		if(node==null)
			return ;
		getSumGreaterUtil(node.right,sumGreater);
		int d=(Integer)node.data;
		int temp=(Integer)node.data;
		node.data=sumGreater[0];
		sumGreater[0]+=d;
		getSumGreaterUtil(node.left, sumGreater);
		
		return ;
	}
	
	public void getMaxSumLeaftoLeaf(){
		System.out.println();
		int[] maxSum=new int[]{Integer.MIN_VALUE};
		getMaxSumLeaftoLeafUtil(root, maxSum);
		System.out.println(" Maximum Sum Leaf to Leaf is "+maxSum[0]);
	}
	private int getMaxSumLeaftoLeafUtil(TreeNode node, int[] maxSum){
		if(node==null)
			return 0;
		int left_sum=getMaxSumLeaftoLeafUtil(node.left, maxSum);
		int right_sum=getMaxSumLeaftoLeafUtil(node.right, maxSum);
		int curr_sum=max(left_sum, right_sum)+(Integer)node.data;
		int maxS=left_sum+right_sum+(Integer)node.data;
		if(maxS>maxSum[0]){
			maxSum[0]=maxS;
		}
		return curr_sum;
	}
	
	
	
	public void constructTree1() {
		root = new TreeNode(11);
		root.left = new TreeNode(2);
		root.right = new TreeNode(29);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		// root.left.left.left = new Tnode(2);
		// root.left.left.right = new Tnode(6);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(40);

		root.right.right.left = new TreeNode(35);

	}
	
	
}
