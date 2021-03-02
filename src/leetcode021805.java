public class leetcode021805 {
    //best-time-to-buy-and-sell-stock
    public static void main(String[] args){
        int[] prices = {7,6,4,3,1};//{7,1,5,3,6,4};
        maxProfit(prices);
    }
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int[] dp = new int[len];
        int min = prices[0];
        int answer= 0;
        dp[0]=0;
        for(int i = 1 ; i < len ; i++){
            if(prices[i]-min>dp[i-1]){
                answer = prices[i]-min;
                dp[i]=answer;
            }
            else{
                dp[i]=dp[i-1];
            }
            min=Math.min(min,prices[i]);

        }
        System.out.println(answer);
        return answer;
    }
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int[] dp = new int[len];
        int min = prices[0];
        dp[0]=0;
        for(int i = 1 ; i < len ; i++){
            dp[i] = (prices[i]-min>dp[i-1]? prices[i]-min:dp[i-1]);
            min=Math.min(min,prices[i]);
        }
        return dp[len-1];
    }//더 가볍게 짜보기
}
