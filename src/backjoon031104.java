import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon031104 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin= new int[n];
        for(int i = 0 ; i < n ; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        //System.out.println(solution(n,k,coin));
        bw.write(solution(n,k,coin) + "\n");
        bw.close();
        br.close();
    }
    public static int solution(int n ,int k  , int[] coin){
        int[] dp =new int[k];
        Arrays.fill(dp,100002);
        dp[0]=0;
        for(int i = 0 ; i < k ; i++){
            for(int j=0;j<n;j++){
                if(i+coin[j]<k) dp[i+coin[j]] = Math.min(dp[i+coin[j]],dp[i]+1);
            }
        }
        return  dp[k-1] == 100002 ? -1 : dp[k-1];
    }
}
