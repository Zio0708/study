public class leetcode021801 {
    public static void main(String[] args){
        countBits(3);
    }
    public static int[] countBits(int num) {
        int[] dp;
        if(num ==1){
            dp = new int[]{0, 1};
            return dp;
        }
        if(num==2){
            dp = new int[]{0,1,1};
            return dp;
        }
        dp = new int[num];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        int cnt=1;
        while(cnt <=num){
            dp[cnt]=1;
            cnt *=2;
        }
        cnt=2;
        for(int i =3; i <=num; i++){
            if(dp[i] == 1){
                cnt*=2;
            }
            else{
                dp[i] = dp[cnt]+dp[i-cnt];
            }
        }
        return dp;

    }
}
