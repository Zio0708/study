import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class study032104 {
    static int n;
    static int[][] map;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n= Integer.parseInt(br.readLine());
        map = new int[n][n];
        answer= new int[n+1];
        for(int i = 0 ;i< n;i++){
            String maps= br.readLine();
            for(int j = 0 ; j < n ; j++){
                map[i][j]= Integer.parseInt(String.valueOf(maps.substring(j,j+1)));
                //dp[i][j]=map[i][j];
            }
        }
        solution();
    }
    public static void solution(){
        int cnt=1;

        while(cnt <=n) {
            answer[cnt]=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(checkLen(i+cnt,j+cnt)){
                        if(checkAns(i,j,cnt)){
                            answer[cnt]++;
                        }
                    }
                }
            }
            System.out.println(answer[cnt]);
            cnt++;
        }
    }
    private static boolean checkLen(int i, int j) {
        if(i >= n || j>=n){
            return false;
        }
        return true;
    }

    private static boolean checkAns(int i, int j,int cnt) {
        int answer=0;
        System.out.println(i+" "+j+" "+cnt);
        for(int y= i ; y<i+cnt;y++){
            for(int x=j;j<j+cnt;j++){
                answer+=map[y][x];
            }
        }
        if(answer == cnt*cnt) return true;
        return false;
    }

}
