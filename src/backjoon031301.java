import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon031301 {
    //https://www.acmicpc.net/problem/2805
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] tree= new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i= 0 ;i<n; i++){
            tree[i]= Integer.parseInt(st.nextToken());;
        }
        bw.write(solution(n,m,tree) + "\n");
        bw.close();
        br.close();
    }
    private static int solution(int n, int m,int[] tree) {
        Arrays.sort(tree);
        int left= 1;
        int right= tree[n-1];
        int mid;
        long cnt;
        while(left <= right){
            mid = (left+right)/2;
            cnt=0;
            for(int i = 0; i < n;i++){
                if(tree[i] >mid) {
                    cnt += tree[i] - mid;
                }
            }
            if(cnt >= m){
                left= mid+1;
            }
            else{
                right= mid-1;
            }
        }
        return right;
    }
}
