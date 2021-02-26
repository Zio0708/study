import java.util.Arrays;

public class programmers022605 {
    public static void main(String[] args){
        solution(6);
    }
    public static int[] solution(int n) {

        int[][] map = new int[n][n];
        int max = n*(n+1)/2;
        int[] answer = new int[max];
        int cnt = 1;
        int y= 0;
        int x= 0;
        for(int[] m :map ){
            Arrays.fill(m,0);
        }
        map[y][x]=cnt;
        cnt+=1;
        while(cnt  <= max ){
            while( y+1 < n && map[y+1][x] ==0 && cnt <= max){
                y+=1;
                System.out.println(y+" "+x+" "+cnt);
                map[y][x] = cnt++;
            }
            while( x+1 < n && map[y][x+1] ==0 && cnt <= max){
                x+=1;
                System.out.println(y+" "+x+"  "+cnt);
                map[y][x] = cnt++;
            }
            while( map[y-1][x-1] ==0 && cnt <= max){
                y-=1;
                x-=1;
                System.out.println(y+" "+x+"   "+cnt);
                map[y][x] = cnt++;
            }
        }
        cnt=0;
        for(int i= 0 ; i < n ; i++){
            for(int j = 0; j <= i ; j++){
                answer[cnt++] = map[i][j];
            }
        }

        return answer;
    }
}
