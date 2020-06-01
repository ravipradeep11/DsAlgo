import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		int [][]M;
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String  str=br.readLine();
		String[] arr=str.split(" ");
		int ROW=Integer.parseInt(arr[0]);
		int COL=Integer.parseInt(arr[1]);
		M=new int[ROW][COL];
		for (int i = 0; i < ROW; i++) {
			str=br.readLine();
			for (int j = 0; j < COL; j++) {
				if(str.charAt(j)=='Y')
				M[i][j]=1;
				else
					M[i][j]=0;
			}
		}
		
		M=new int[][]{{1,0,0,1},{0,1,0,1},{0,1,0,0}};
		int isl=countIslands(M, 3, 4);
		System.out.println("Number of islands is "+isl);;
	int k=0;
	int res=0;
	while(k<=isl)
	{
		res=res+binomialCoeff(isl, k);
		k=k+2;
	}
	System.out.println("res is "+res);	
		
	}
	static int binomialCoeff(int n, int k)
	{
	    int res = 1;
	 
	   
	    if ( k > n - k )
	        k = n - k;
	 
	 
	    for (int i = 0; i < k; ++i)
	    {
	        res *= (n - i);
	        res /= (i + 1);
	    }
	 
	    return res;
	}
	static boolean isSafe(int M[][], int rowG, int colG, boolean visited[][],
			int ROW, int COL) {
		
		System.out.println("rowG is "+rowG+"colG is "+colG);
		return (rowG >= 0) && (rowG < ROW) && 
				(colG >= 0) && (colG < COL) && 
				(M[rowG][colG] == 1 && !visited[rowG][colG]); 
	}


	static void DFS(int M[][], int row, int col, boolean visited[][], int COL,
			int ROW) {
		
		int rowNbr[] = { -1,  0, 0,  1};
		int colNbr[] = { 0,  -1, 1, 0 };

		visited[row][col] = true;


		for (int k = 0; k < 4; ++k) {
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited, ROW,COL)) {
				DFS(M, row + rowNbr[k], col + colNbr[k], visited, COL, ROW);
			}
		}
	}

	static int countIslands(int M[][], int ROW, int COL) {

		boolean visited[][] = new boolean[ROW][COL];

	
		int count = 0;
		for (int i = 0; i < ROW; ++i)
			for (int j = 0; j < COL; ++j)
				if (M[i][j] == 1 && !visited[i][j]) 
				{
					DFS(M, i, j, visited, COL, ROW); 
					++count; 
				}

		return count;
	}

}
