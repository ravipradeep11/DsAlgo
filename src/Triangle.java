import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;


public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str;
		try {
			str = br.readLine();
			int t=Integer.parseInt(str);
			while(t-->0)
			{
				str=br.readLine();
				int lines=Integer.parseInt(str);
				int[][] triangle=new int[lines+1][lines+1];
				for(int i=0;i<lines+1;i++){
					for(int j=0;j<lines+1;j++)
						triangle[i][j]=-1;
				}
				for(int i=1;i<=lines;i++){
					str=br.readLine();
					String[] currLine=str.split(" ");
					for(int j=0;j<i;j++){
						triangle[i][j]=Integer.parseInt(currLine[j]);
						
					}
					
				}
//				for(int i=0;i<lines+1;i++){
//					for(int j=0;j<lines+1;j++)
//						System.out.print(" "+triangle[i][j]);
//					System.out.println();
//				}
				System.out.println(""+getMaxSum(triangle, lines+1));
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	
		

	}
	
	
	static int getMaxSum(int[][] triangle,int n){
		int[][] dp=new int[n][n];
		int leftParent,upParent;
		leftParent=upParent=0;
		for(int k=0;k<n-1;k++)
			dp[n-1][k]=triangle[n-1][k];
		for (int i = n-1; i >0; i--) {
			for (int j = i-1; j >=0; j--) {
				//Check if up exists
				if(triangle[i-1][j]!=-1){
					int s=triangle[i-1][j]+dp[i][j];
					if(s>=dp[i-1][j])
						dp[i-1][j]=s;
					
						
				}
				//Check if Left Exists
				
				if(j>0){
					int s=triangle[i-1][j-1]+dp[i][j];
					if(s>=dp[i-1][j-1])
						dp[i-1][j-1]=s;
					
				}
			}
		}
		
		return dp[1][0];
	}

}
