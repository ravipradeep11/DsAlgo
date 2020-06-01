package trees;

public class SegmentTree {

	int[] stree;

	public static void main(String[] args) {

		SegmentTree s = new SegmentTree();

		
		int [] arr=new int[]{1,2,3,4,5,6,7};
		int start=2;int end =5;
		System.out.println(" " + s.ceilgetLog(arr.length));
		System.out.println();
		System.out.println(" Sum between indices is "+s.getSumQuery(arr, start, end));

	}


	public void constructTree(int[] arr, int n) {
		// TODO Auto-generated constructor stub

		int maxSize = 2 * ceilgetLog(n) - 1;
		int[] st = new int[maxSize];

	}

	public int getSumQuery(int [] arr,int start,int end)
	{
		int n=arr.length;
		int maxSize = (int) (2*(Math.pow(2, ceilgetLog(n))) - 1);
		System.out.println(" max size is "+maxSize);
		int[] st = new int[maxSize];
		constructSegmentTreeUtil(arr, 0, n-1, st, 0);
		return getSumQueryUtil(st,0,n-1,start,end,0);
		
		
	}
	private int getSumQueryUtil(int [] st,int ss,int se,int qs,int qe,int index)
	{
		if(ss>=qs&&qe>=se)
			return st[index];
		if(ss>qe||se<qs)
			return 0;
		int mid=ss+(se-ss)/2;
		
		return getSumQueryUtil(st,ss,mid,qs,qe,2*index+1)+getSumQueryUtil(st,mid+1,se,qs,qe,2*index+2);
	}
	
	private int constructSegmentTreeUtil(int[] arr, int ss, int ee, int[] st,
			int index) {

		if (ss == ee) {
			st[index] = arr[ss];
			return st[index];
		}
		int mid = (ss + ee) / 2;
		st[index] = constructSegmentTreeUtil(arr, ss, mid, st, 2 * index + 1)
				+ constructSegmentTreeUtil(arr, mid + 1, ee, st, 2 * index + 2);

		return st[index];
	}

	public SegmentTree() {
		// TODO Auto-generated constructor stub
	}

	private int ceilgetLog(int n) {

		boolean isPowerofTwo = false;
		if ((n & (n - 1)) == 0)
			isPowerofTwo = true;
		if (n == 1)
			return 0;
		int res = 0;
		while (n > 1) {
			res++;
			n = n / 2;
		}
		if (!isPowerofTwo)
			res++;
		return res;
	}
}
