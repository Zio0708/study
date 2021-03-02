public class leetcode021809 {
    public int minPathSum(int[][] grid) {
        //구해야 하는 것: 경로의 최소값
        //그럼 저장해야 하는 것 : 각 경로의 비용
        //비교해야 하는것 : 경로별 최소 값을 비교해서 최소값만 저장한다.
        int yLen = grid.length;
        int xLen = grid[0].length;
        int[][] dp = new int[yLen][xLen];
        dp[0][0]= grid[0][0];
        for(int y= 1 ; y<yLen;y++){
            dp[y][0] = grid[y][0]+dp[y-1][0];
        }
        for(int x= 1 ; x<xLen;x++){
            dp[0][x] = grid[0][x]+dp[0][x-1];
        }
        for(int y=1; y< yLen;y++){
            for(int x= 1 ; x<xLen;x++ ){
                dp[y][x] = grid[y][x]+ Math.min(dp[y-1][x],dp[y][x-1]);
            }
        }
        return dp[yLen-1][xLen-1];
    }
}
