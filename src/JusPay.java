import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JusPay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		try {
			str = br.readLine();
			int n = Integer.parseInt(str);
			int[] parent = new int[n];
			str = br.readLine();
			String[] p = str.split(" ");
			for (int i = 0; i < n; i++) {
				parent[i] = Integer.parseInt(p[i]);
				//System.out.print(" " + parent[i]);
			}
		
			int h=getHeight(parent,n);
			System.out.println(""+h);
			System.out.println(""+getMaxChildRen(parent, n));
			System.out.println(""+getLCA(3,4,parent,h));;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int getLCA(int c1,int c2,int []parent,int h)
	{
		
		int i1=0;int i2=0;
		int a,b;
		int[] ancestor1=new int[h];
		int[] ancestor2=new int[h];
		do
		{
			ancestor1[i1++]=c1;
			c1=parent[c1];
			
		}while(c1!=-1);
		
//		
		do
		{
			ancestor2[i2++]=c2;
			c2=parent[c2];
			
		}while(c2!=-1);
//		for (int i = i2-1; i >-1; i--) {
//			System.out.print("  "+ancestor2[i]);
//		}
		int i=i1-1;
		int j=i2-1;
		while(i>-1&&j>-1&&ancestor1[i]==ancestor2[j])
		{
			i--;j--;
		}
		
		
		return ancestor1[i+1];
	}
	public static int getMaxChildRen(int[] parent, int n) {
		int count[] = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (parent[i] != -1) {
				count[parent[i]]++;
				if (max < count[parent[i]])
					max = count[parent[i]];
			}

		}
		return max;
	}

	public static int getHeight(int[] parent, int n) {
		int[] depth = new int[n];
		Arrays.fill(depth, 0);
		for (int i = 0; i < n; i++) {
			fillDepth(depth, i, parent);
		}
		int height = 0;
		for (int i = 0; i < n; i++) {
			if (height < depth[i])
				height = depth[i];
		}

		return height;
	}

	private static void fillDepth(int[] depth, int i, int[] parent) {
		if (parent[i] == -1) {
			depth[i] = 1;
			return;
		}
		if (depth[i] != 0)
			return;

		fillDepth(depth, parent[i], parent);
		depth[i] = depth[parent[i]] + 1;

	}

}
