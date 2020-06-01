package trees;

import java.util.Random;

public class ArrayUtil {

	/*
	 * public static int binarySearch(Comparable[] array, Comparable data) {
	 * 
	 * return binarySearchUtil(array, data, 0, array.length-1); }
	 */

	/*
	 * private static int binarySearchUtil(Comparable[] array, Comparable data,
	 * int start, int end) { int mid=(start+end)/2;
	 * if(array[mid].compareTo(data)==0) { return mid; } }
	 */

	public static int[] generate1DIntegerArray(int min, int max, int size) {
		int offset = max - min + 1;
		int[] A = new int[size];
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			A[i] = rand.nextInt(offset) + min;

		}

		return A;
	}

	public static char[] generate1DCharArray(char min, char max, int size) {
		int offset = max - min + 1;
		char[] A = new char[size];
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			A[i] = (char) (rand.nextInt(offset) + (int) min);

		}

		return A;
	}

	public void binarySearch(int[] A, int data) {

		System.out.println(" " + data + " found at index"
				+ binS(A, 0, A.length, data));

	}

	private int binS(int[] A, int low, int high, int data) {

		int mid = low + (high - low) / 2;
		if (low > high || high > A.length - 1 || low < 0)
			return -1;
		if (A[mid] == data) {
			return mid;
		} else if (A[mid] < data) {
			return binS(A, mid + 1, high, data);
		} else
			return binS(A, low, mid - 1, data);
	}

	public void binSearchRepeatedArray(int[] A, int data) {
		System.out.println();
		System.out.println(" " + data + " found at index "
				+ binSearchRepeatedArray(A, 0, A.length - 1, data));

	}

	private int binSearchRepeatedArray(int[] A, int low, int high, int data) {

		if (high >= low) {
			int mid = (low + high) / 2; /* low + (high - low)/2; */
			if ((mid == 0 || data > A[mid - 1]) && A[mid] == data)
				return mid;
			else if (data > A[mid])
				return binSearchRepeatedArray(A, (mid + 1), high, data);
			else
				return binSearchRepeatedArray(A, low, (mid - 1), data);
		}
		return -1;

	}

	public void minIndexinRotated(int[] A) {
		System.out.println("Minimum  in rotated array is"
				+ minIndexinRotatedUtil(A, 0, A.length - 1));
	}

	private int minIndexinRotatedUtil(int[] A, int low, int high) {
		if (high >= low) {
			int mid = (low + high) / 2;
			if (high == low)
				return A[low];
			if (mid < high && A[mid + 1] < A[mid])
				return A[mid + 1];
			else if (mid > low && A[mid - 1] > A[mid])
				return A[mid];
			else if (A[high] > A[mid])
				return minIndexinRotatedUtil(A, low, mid - 1);
			else
				return minIndexinRotatedUtil(A, mid + 1, high);
		} else
			return A[0];

	}

	public void smallestSubSumGreater(int[] A, int sum) {
		int len = A.length;
		// int start = 0;
		System.out.println();
		int current_sum = 0;
		int max_sum = current_sum;
		int end = 0;
		int start = 0;
		int minLen = len + 1;
		int minStart = 0;
		int minEnd = 0;
		while (end < len) {
			while (current_sum <= sum && end < len)
				current_sum += A[end++];
			while (current_sum > sum && start < len) {
				if ((end - start) < minLen) {
					minLen = end - start;
					minStart = start;
					minEnd = end - 1;

				}
				current_sum -= A[start++];
			}

		}
		System.out.println("Minimum length array  is " + minLen);
		print1Darray(A, minStart, minEnd);
	}

	public static void print1Darray(int[] A, int start, int end) {
		System.out.println();
		for (int i = start; i <= end; i++) {
			System.out.print(" " + A[i]);
		}
	}
	int getNextLargerIncreasing(int n)
	{
		//System.out.println(" "+n+" min is "+getMinbase(n));
		int k,b;
		b=getNumberofDigits(n);
		int n1=get111(b);
		int minb=getMinbase(b);
		
		if(n>minb)
		k=(n-minb)/n1;
		else
			k=-1;
		System.out.println(" n "+n+" b is "+b+" minb is "+minb+" \n k is "+k+" max allowed "+getMaxKAllowed(b));
		if(k>getMaxKAllowed(b))
		{
			return getMinbase(b+1);
		}else
			return getMinbase(b)+get111(b)*(k+1);
	//	k=
		
		
		
		//return n;
	}
	private int getNumberofDigits(int n){
		if(n==0)
			return 1;
		int count=0;
		while(n!=0)
		{
			count++;
			n=n/10;
		}
		return count;
		
	}
	//private int getNextIn(int )
	private int getMinbase(int b)
	{
		int c=0;
		for(int i=1;i<=b;i++)
		{
			c=c*10+i;
		}
		return c;
	}
	private int get111(int b)
	{
		
		String s="";
		for(int i=0;i<b;i++)
		{
			s=s+"1";
		}
		return Integer.parseInt(s);
	}
	
	private int getMaxKAllowed(int b)
	{
		
		String s="";
		for(int i=0;i<b;i++)
		{
			s=s+"9";
		}
		int max;
		max=(Integer.parseInt(s)-getMinbase(b))/get111(b)-1;
		return max;
	}
}
