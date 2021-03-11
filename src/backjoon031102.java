import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon031102 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] a= new int[n];
        for(int i = 0 ; i < n ; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        bw.write(solution(n,a) + "\n");
        bw.close();
        br.close();
    }
    public static int solution(int n , int[] a){
        int[] dp = new int[n];
        Arrays.fill(dp,1001);//주의! 최댓값을 땡기는데 생각없이좀 하지 말자
        dp[0]= 0;
        for(int i = 0; i<n-1;i++){
            for(int j=1;j<=a[i];j++){
                if(i+j<n) dp[i+j] = Math.min(dp[i+j],dp[i]+1);
            }
        }
        return dp[n-1]=(dp[n-1] == 1001 ? -1: dp[n-1]);
    }
}
