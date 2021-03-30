import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study033003 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        dp = new int[20];
        int T= Integer.parseInt(br.readLine());
        dp[0]=1;
        for(int i = 0 ; i <= 11;i++){
            dp[i+1]+=dp[i];
            dp[i+2]+=dp[i];
            dp[i+3]+=dp[i];
        }

        for(int i = 0 ; i < T; i++){
            System.out.println(solution(Integer.parseInt(br.readLine())));
        }
        br.close();

    }
    public static int solution(int n){
        return dp[n];
    }
}
