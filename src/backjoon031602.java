import java.io.*;
import java.util.StringTokenizer;

public class backjoon031602 {
    static int answer=0;
    static long a;
    static long b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());


        bw.write(solution() + "\n");
        bw.close();
        br.close();
    }

    private static int solution() {
        dfs(4);
        dfs(7);
        return answer;
    }

    private static void dfs(long cnt) {
        if(b < cnt){
            return;
        }
        if(a<=cnt) answer+=1;
        dfs(cnt*10+4);
        dfs(cnt*10+7);
    }
}
