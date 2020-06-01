package trees;

public class Main {

	public static void main(String[] args) {
		int[] A;
		// A=ArrayUtil.generate1DIntegerArray(0, 10, 10);
		// A= new int[15];
		A = new int[] { 32, 16, 48, 8, 24, 40, 56, 4, 12, 20, 28, 36, 44, 52,
				60 };
		// A=new int[]{32,16,48,8,24,40,56,4,12,20,28,36,44,52,60};
		// A=new int[]{4,8,12,16,20,24,28,32,36,40,44,48,52,56,60,74};
		char[] C;
		C = ArrayUtil.generate1DCharArray('A', 'Z', 10);
		BinaryTreeExtended root = new BinaryTreeExtended();
		BinarySearchTree root1 = new BinarySearchTree();
		// root=new AvlTree();
		for (int i = 0; i < A.length; i++) {
			System.out.print(" " + A[i]);

			root.insert(A[i]);
			root1.insert(A[i]);
		}

		// root.getMirrorImage();root.getInorder();
		// root.reverseAlternateLevels();

		// root1.insert(26);
		/*
		 * for (int i = 0; i < C.length; i++) { System.out.print(" "+C[i]);
		 * 
		 * root.insert(C[i]); }
		 */
		// .root.constructTree();
		System.out.println();
		root.getInorder();
		root.checkBST();
		// root.convertToSumtree();
		System.out.println();
		// root.constructTree();
		root.getInorder();
		root.getRightView();
		root.getLeftView();
		root.printLevels();
		// root.getMirrorTree();
		// root.getInorder();
		// root.getMaxLeaftoLeafSum();
		// root.isStructureSameAs(root1);
		// root.getBreadthFirstTraversal();
		// root.getBreadthFirstTraversalSpiral();
		// root.getDepthFirstTraversal();
		// root.getInorderbyMorris();
		// root.getNodesatKUnits(1, 16);
		// root.printVerticalView();
		// root.getMirrorTree();
		// root.getInorder();
		// root.getLeastCommonAncestor(14, 68);
		/*
		 * Dog d=new Dog(); Animal a=(Animal)d; Animal a1=new Dog(); Dog
		 * d1=(Dog) new Animal(); d1.print();
		 */
		System.out.println();
		root.getKthSmallest(40);
		//root.convertLeavestoDLL();
		root.convertToDoublyLinkedList();
	}
}
