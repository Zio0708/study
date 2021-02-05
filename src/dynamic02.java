import java.util.Arrays;

import static java.lang.Math.min;

public class dynamic02 {
    static int[] dp=new int[1000];
    public static void main(String[] args){
        Arrays.fill(dp,-1);
        System.out.println(makeOne(10));
    }

    private static int makeOne(int i) {
        int result;
        if(i == 1){return 0;}//처음 조건 지정
        if(dp[i] != -1){return dp[i];}//계산이 되어있으면 그대로 돌려줌 (DFS의 성질)
        result = makeOne(i-1)+1;//+1을 더할때
        if(i%2 ==0){ result = min(result,makeOne(i/2)+1); }//2로 나눌때
        if(i%3 ==0){ result = min(result,makeOne(i/3)+1); }//3로 나눌때
        //위에서 3개 다 비교해봄
        dp[i] =result;//가장 효율적인 것만 저장
        return result;//리턴
    }
}
