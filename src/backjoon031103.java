import java.io.*;
import java.util.StringTokenizer;

public class backjoon031103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] wine= new int[n];
        for(int i = 0 ; i < n ; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }
        bw.write(solution(n,wine) + "\n");
        bw.close();
        br.close();
    }
    public static int solution(int n , int[] wine){
        int[] dp = new int[n];
        dp[0]=wine[0];
        if(n >=2) dp[1] = wine[0]+wine[1];
        if(n >=3) dp[2] = Math.max(dp[0]+wine[2], Math.max(dp[1],wine[1]+wine[2]));
        for(int i=3;i<n;i++){
            dp[i] = Math.max(dp[i-2]+wine[i] , dp[i-3]+wine[i]+wine[i-1]);
            //dp[i] = Math.max(dp[i-3]+wine[i-1],dp[i]);
            dp[i] = Math.max(dp[i-1],dp[i]);
        }
//
//        for(int d:dp){
//            System.out.print(d+" ");
//        }
        return dp[n-1];
    }
}
