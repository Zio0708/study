import java.util.Arrays;

public class naver03 {
    static int[] number={6,2,5,5,4,5,6,3,7,6};
    static int answer = 0;
    static int zerocheck= 0;
    public static void main(String[] args){
        solution(11);
    }
    public static long solution(int k){
        Arrays.sort(number);
        BFS(0,k);
        //System.out.println(answer);
        //System.out.println(zerocheck/3);
        return answer-(zerocheck/3);
    }
    private static void BFS(int result,int k) {
        if(result == k){
            answer+=1;
            return;
        }
        else if(result>k){
            return;
        }
        for(int i = 0 ; i < 10  ; i ++){
            if(result+number[i]==k && number[i] ==6 && k != 6) {
                zerocheck += 1;
            }
                BFS(result + number[i], k);
        }
    }

}
