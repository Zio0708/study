import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon031901 {
    static int n;
    static int m;
    static int[] a;
    static int[] b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n  = Integer.parseInt(br.readLine());
        a = new int[n];
        st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        b = new int[m];
        st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m ; i++){
            b[i]=Integer.parseInt(st.nextToken());
        }
        solution();
        br.close();
    }

    private static void solution() {
        Arrays.sort(a);
        int left;
        int right;
        int mid;
        boolean check;
        for(int i=0;i<m;i++){
            left =0;
            right=n-1;
            check=false;
            //System.out.println(i+"번째");
            while(left<=right){
                mid = (left+right)/2;
                if(a[mid]==b[i]){
                    check=true;
                    break;
                }
                else if(a[mid]<b[i]){
                    left = mid+1;
                }
                else{
                    right= mid-1;
                }
            }
            if(check) System.out.println("1");
            else System.out.println("0");
            }
    }
}
