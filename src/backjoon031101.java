import java.io.*;
import java.util.StringTokenizer;

public class backjoon031101 {
    //자바 내는거 거지같네...
    //10835 카드게임
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] left= new int[n];
        for(int i = 0 ; i < n ; i++){
            left[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] right= new int[n];
        for(int i = 0 ; i < n ; i++){
            right[i] = Integer.parseInt(st.nextToken());
        }
        solution(n,left,right);
    }
    public static int solution(int n , int[] left, int[] right){
        int[][] dp = new int[n+1][n+1];
        dp[n][n]=0;
        for(int i =n-1; i>-1; i--){
            for(int j = n-1;j>-1;j--){
                dp[i][j]= Math.max(dp[i+1][j+1],dp[i+1][j]);
                if(right[j] <left[i]) dp[i][j]= Math.max(dp[i][j],dp[i][j+1]+right[j]);
            }
        }
        System.out.println(dp[0][0]);
        return dp[0][0];

    }
}
