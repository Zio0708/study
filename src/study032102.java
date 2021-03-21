import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class study032102 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String road = br.readLine();

        solution(n,road);

    }

    private static void solution(int n,String road) {
        int[] dp = new int[n];
        dp[0]=1;
        if(road.length() >1 && road.charAt(1) =='1'){
            dp[1]=1;
        }
        for(int i =2; i<n;i++){
            if(road.charAt(i-1) =='1'){
                dp[i]+=dp[i-1];
            }
            if(road.charAt(i-1) =='1'){
                dp[i]+=dp[i-2];
            }
            //System.out.println(dp[i]);
        }
        System.out.println(dp[n-1]);

    }

}
