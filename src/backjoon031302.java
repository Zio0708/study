import java.io.*;
import java.util.StringTokenizer;

public class backjoon031302 {
    static int[][] map;
    static int[][] dp;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());//n 받기
        map= new int[n][n];//배열인 경우 실행
        dp = new int[n][n];
        for(int y=0 ; y<n;y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());//한줄배열인 경우
                dp[y][x]=-1;
            }
        }
        bw.write(solution() + "\n");
        bw.close();
        br.close();
    }
    private static int solution() {
        int n = map.length;
        answer=0;
        for(int y=0 ; y<n;y++) {
            for (int x = 0; x < n; x++) {
                if(dp[y][x] == -1){
                    dfs(n,y,x,1,1000001);
                }
            }
        }
        return answer;
    }
    private static void dfs(int n,int y, int x, int i,int cnt) {
        if(y<0 || y>=n || x <0 || x>=n) return; //
        if(dp[y][x] >= i || cnt < map[y][x] ) return;
        dp[y][x] = i ;
        dfs(n,y,x+1,i+1,map[y][x]);
        dfs(n,y-1,x,i+1,map[y][x]);
        dfs(n,y,x-1,i+1,map[y][x]);
        dfs(n,y+1,x,i+1,map[y][x]);
        answer= Math.max(i,answer);
        return;
    }
    //조건 1: 더 커야함
    //조건 2: 벗어 나면안됨
    //조건 3: 갔는데 이미 갔던 곳이면 더하..?
    //작아지는 경우를 계산하고
    //dp에 추가하면서 가다가
    //이미 방문했던 곳이면
}
