package trees;

public class ArrayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = new int[] { 5, 8, 13, 17, 45, 64, 72, 85 };
		// A=new int []{1,1,2,2,2,3,3,4,4,5,6,6,6,6};
		// A=new int[]{6,7,8,9,1,3,4,5};
		ArrayUtil util = new ArrayUtil();
		int arr1[] = new int[] { 1, 4, 45, 6, 10, 19 };
		int arr2[] = new int[] { 1, 10, 5, 2, 7 };
		int arr3[] = new int[] { 1, 11, 100, 1, 0, 200, 3, 2, 1, 250 };
		util.binarySearch(A, 173);
		util.binSearchRepeatedArray(A, 4);
		util.minIndexinRotated(A);
		MinHeap minH = new MinHeap(4);
		MaxHeap maxH = new MaxHeap(4);
		A = new int[] { 14, 5, 32, 2, -4, 8, -10 };
		for (int i = 0; i < A.length; i++) {
			minH.insert(A[i]);
			System.out.println(" Current Minimim is " + minH.peek());
			maxH.insert(A[i]);
			System.out.println(" Current Maximum is " + maxH.peek());
		}
		minH.print();
		maxH.print();
		util.smallestSubSumGreater(arr1, 51);
		util.smallestSubSumGreater(arr2, 9);
		util.smallestSubSumGreater(arr3, 280);
		System.out.println("\n "+util.getNextLargerIncreasing(4));
	}

}
