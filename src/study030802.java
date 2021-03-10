public class study030802 {
    public static void main(String[] args){

    }
    public static int solution(int[] n , int k){
        int len = n.length;
        int[] dp =new int[10001];
        for (int i = 0; i < len; i++) {
            for (int j = n[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - n[i]] + 1);
            }
        }
        return dp[k];
    }

}
