public class dynamic04 {

    static int[] moneyAry;
    public static void main(String[] args){
        int[] money = {1, 2, 3, 1};
        solution(money);
    }
    public static int solution(int[] money) {
        //dp[0][0]=(dp[1][1]+moneyAry[0]);
        //dp[0][1]=(dp[1][0]) 와 dp[1][1] 중에 비싼거;
        //dp[1][0]=dp[2][1]+moneyAry[1]
        //dp[1][1]=dp[2][0] 와 dp[2][1] 중에 비싼거;
        int len = money.length;

        int[] dp1 = new int[len];
        int[] dp2 = new int[len-1];
        dp1[0]=0;
        dp1[1]=money[1];
        for(int i = 2;  i < len; i++){
            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+money[i]);
        }
        for(int i = 2 ; i< len-1;i++){
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+money[i]);
        }
        return Math.max(dp1[len-1],dp2[len-2]);
    }

}
