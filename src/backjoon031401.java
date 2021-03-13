import java.io.*;
import java.util.StringTokenizer;

public class backjoon031401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String n = br.readLine();//n 받기
        bw.write(solution(n) + "\n");
        bw.close();
        br.close();
    }

    private static int solution(String n) {
        int len = n.length();
        int[] dp = new int[5001];
        if(n.charAt(0)=='0') return 0;
        dp[0]=1;
        if(n.length() ==1) return dp[0];
        if(n.length() >=2 && Integer.parseInt(n.substring(0,2)) <= 26 && Integer.parseInt(n.substring(0,2))>=10){
            dp[1]=2;
        }
        else{
            dp[1]=1;
        }
        int cnt;
        int cntz;
        for(int i = 2; i<= len ; i++){
            cnt=Integer.parseInt(n.substring(i-2,i));
            cntz=Integer.parseInt(n.substring(i-1,i));
            if(cntz !=0) {
                dp[i] += dp[i - 1] % 1000000;
            }
            if(cnt <= 26 && cnt>=10){
                dp[i] +=dp[i-2] % 1000000;
            }
            System.out.println(cntz+" "+cnt+" : "+dp[i]);

        }
        return dp[len-1];
    }
}

