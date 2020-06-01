package trees;

public class MainExtensionTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeAmazon tree=new BinaryTreeAmazon();
		tree.constructTree();
		tree.getInorder();
		tree.getMaxSumLeaftoLeaf();
		tree.constructTree1();
		tree.convertToSumTree();
		tree.getInorder();
		int[] A;
		BinaryTreeAmazon tree2=new BinaryTreeAmazon();
		A = new int[] { 32, 16, 48, 8, 24, 40, 56, 4, 12, 20, 28, 36, 44, 52,
				60 };
		for (int i = 0; i < A.length; i++) {
			tree2.insert(A[i]);
		}
		tree2.getInorder();
		System.out.println();
		tree2.findLeastCommonAncestor(44,52);
		
	}

}
