public class study030702 {
    public static void main(String[] args){
        int[] dp = new int[4];
        int N = 4;
        int[] arr =new int[5];
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }

    }
}
