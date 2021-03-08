import java.util.Arrays;

public class study030801 {
    public static void main(String[] args){
        int[] arr= {1, 2, 0, 1, 3, 2, 1, 5, 4, 2};
        solution(arr);
    }
    public static void solution(int[] arr){
        int len =arr.length;
        int[] dp = new int[len];
        Arrays.fill(dp,101);
        dp[0]=0;
        for(int i = 0 ; i < len;i++){
            for(int j = 1; j<=arr[i];j++) {
                if(i+j <len) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }
        for(int n : dp){
            System.out.print(n+" ");
        }
        System.out.println(dp[len-1]);
    }
}
