import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class study032401 {
    static int K;
    static int N;
    static long[] line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        line = new long[K];

        for(int i=0;i<K;i++){
            line[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(line);
        solution();
    }
    public static void solution(){
        long left= 1;
        long right=line[K-1];
        long mid;
        long answer;
        while(left<=right){
            answer=0;
            mid = (left+right)/2;
            for(int i = 0 ;i<K;i++){
                answer+= line[i]/mid;
            }
            if(answer<=N)//갯수가 적다는 의미 = 길다는 의미
            {
                right = mid-1;
            }
            else{
                left =mid+1;
            }
        }
        System.out.println(right);



    }
}
