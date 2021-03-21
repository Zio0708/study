import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class study032103 {
    static int n;
    static int m;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        m= Integer.parseInt(st.nextToken());
        n= Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 0; j < m ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                //System.out.println(map[i][j]);
            }
        }
        solution();

    }

    private static void solution() {
        int[][] dp = new int[n][m];
        dp[0][0]=map[0][0];
        for(int i = 1;i<n;i++){
            dp[i][0] = dp[i-1][0]+map[i][0];
        }
        for(int j=1;j<m;j++){
            dp[0][j] = dp[0][j-1]+map[0][j];
        }
        for(int i = 1;i<n;i++){
            for(int j=1;j<m;j++) {
                dp[i][j]=map[i][j]+Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
//        for(int i = 0;i<n;i++){
//            for(int j=0;j<m;j++) {
//                System.out.print(dp[i][j]+"  ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[n-1][m-1]);
    }

}
