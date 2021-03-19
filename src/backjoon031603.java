import java.io.*;

public class backjoon031603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n  = Integer.parseInt(br.readLine());
        bw.write(solution(n) + "\n");
        bw.close();
        br.close();
    }
    public static int solution(int n){
        int[] dp = new int[n+3];
        dp[0]=1;
        dp[1]=1;
//        for(int i = 0 ; i <= n ; i++){
//            dp[i+1]=dp[i+1]+dp[i];
//            dp[i+2]=dp[i+2]+dp[i];
//            System.out.println((i+1) +" "+(i+2)+"/ "+dp[i+1]+" "+dp[i+2]);
//        }// 작은 숫자에서 큰숫자로 쌓아올리는 방식
        for(int i=2; i<=n;i++){
//            dp[n]+= dp[n-2];
//            dp[n]+= dp[n-1];
            dp[i]=dp[i-2]+dp[i-1];
        }// 큰숫자가 되기위해선 작은 숫자들이 쌓아졌겠죠?
        //5칸을 쌓기 위해서 어떤 경우의 수들이 더해졌을까?
        //5칸을 쌓기 위한 방법 : 3칸에서 2칸 쌓은거야
        //5칸을 쌓기 위한 방법 2 : 4칸에서 1칸 쌓은거야
        return dp[n];
    }
}
