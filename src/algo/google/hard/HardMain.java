package algo.google.hard;

public class HardMain {
    public static void main(String[] args){

    }
    public int cherryPickup(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        return  dfs(grid,row,col,0,0,col-1,new Integer[row][col][col]);
    }
    private int dfs(int[][]grid,int row,int col,int depth,int c1,int c2,Integer[][][] dp){
        if(depth==row) return 0;
        if(dp[row][c1][c2]!=null) return dp[row][c1][c2];
        int ans=0;
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                int nc1=c1+i;
                int nc2=c2+j;
                if(nc1<col&&nc2<col&&nc1>=0&&nc2>=0){
                    ans=Math.max(ans,dfs(grid,row,col,depth+1,nc1,nc2,dp));
                }
            }
        }
        int cherries=(c1==c2)?grid[depth][c1]:grid[depth][c1]+grid[depth][c2];
        dp[depth][c1][c2]=ans+cherries;
        return dp[depth][c1][c2];
    }


}
