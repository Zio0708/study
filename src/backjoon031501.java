import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class backjoon031501 {
    static int answer;
    static int[] dp;
    static List<List<Integer>> node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());//n 받기
        dp =new int[n+1];
        node =new ArrayList<>();
        for(int i = 0 ; i<=n ;i++){
            node.add(new ArrayList<>());
        }

        int a=0;
        int b=0;
        for(int i = 0 ; i < n-1 ; i++){
            st = new StringTokenizer(br.readLine());
            a= Integer.parseInt(st.nextToken());
            b= Integer.parseInt(st.nextToken());
            node.get(a).add(b);
            node.get(b).add(a);
        }
        bw.write(solution(n) + "\n");
        bw.close();
        br.close();
    }
    public static int solution(int n){
        answer=0;
        dfs(1, -1);
        

        return answer;
    }

    private static void dfs(int bottom, int top) {
        //돈다
        dp[bottom] =1;
        //System.out.println(bottom+" "+top);
        List<Integer> nodes=node.get(bottom);//해당노드의 연결점을 가져옴
        for(int i=0;i<nodes.size();i++){
            if(dp[nodes.get(i)] ==0) {
                dfs(nodes.get(i), bottom);
            }
        }
        //더이상 돌곳이 없을 때까지
        if(top != -1 && dp[bottom]>=0 && dp[top]>=0){
            dp[top] = -1;
            //System.out.println(top+"얼리어답터 등록"+bottom);
            answer+=1;
        }
        return;
    }
}
