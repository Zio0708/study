import java.util.Arrays;

public class programmers {
    public static void main(String[] args){
        System.out.println("nooo");
        int[][] routes ={{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
        solution(routes);
    }
    public static void solution(int[][] routes){
        int cnt = -30001;
        int answer= 0;
        Arrays.sort(routes,(a,b)-> Integer.compare(a[1],b[1]));
        for(int[] route : routes){
            if(cnt<route[0]){
                cnt = route[1] ;
                answer+=1;
            }
        }
        System.out.println(answer);
    }

}
