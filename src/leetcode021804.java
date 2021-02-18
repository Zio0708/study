public class leetcode021804 {
    //climbing-stairs
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i =2; i <= n;i++ ){
            dp[i] = (dp[i-2])+(dp[i-1]);
        }
        return dp[n];
        //구하려는 값: 계단을 오르는 모든 경우의 수
        //저장하는 값: 각 계단의 모든 경우의 수
        //점화식 : n계단 = 두계산을 동시에 오르거나 + 한계단만 오르거나 경우의 수를 모두 더함.
    }
}
