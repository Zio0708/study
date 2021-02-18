public class leetcode021808 {
    //unique-paths 2
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0 ; i<m ; i++){
            if(obstacleGrid[i][0]==1){
                break;
            }
            dp[i][0]=1;
        }
        for(int i = 0 ; i< n ; i++){
            if(obstacleGrid[0][i]==1){
                break;
            }
            dp[0][i]=1;
        }
        for(int y= 1 ; y<m; y++){
            for(int x = 1 ; x<n; x++){
                if(obstacleGrid[y][x] ==1){
                    dp[y][x]=0;
                }
                else {
                    dp[y][x] = dp[y - 1][x] + dp[y][x - 1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
