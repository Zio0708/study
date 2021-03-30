import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class study033001 {
    private static int n;
    private static int map[][];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        map = new int[n][n];
        int[] num = new int[n];
        StringTokenizer st =null;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j <n ; j++) {
                map[i][j] = Integer.valueOf(str.substring(j, j+1));
            }
        }
        divide(0,0, n);
    }
    public static void divide(int x,int y,int size){
        int cnt = map[y][x];

        for(int i = y ; i < y+size; i++){
            for(int j = x; j< x+size; j++){
                if(cnt != map[i][j]){//일치하지 않으면
                    System.out.print("(");
                    size/=2;
                    divide(x,y,size);
                    divide(x+size,y,size);
                    divide(x,y+size,size);
                    divide(x+size,y+size,size);
                    System.out.print(")");
                    return;
                }
            }
        }
        System.out.print(cnt);

        //통일이 안되면 다시 분할한다.



    }
}
