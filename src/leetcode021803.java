import java.util.Arrays;

public class leetcode021803 {
    //maximum-subarray
    public static void main(String[] args){
        maxSubArray(new int[]{1,2});
    }
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int answer=nums[0];
        dp[0]=nums[0];//dp의 경우 'subArray의 최대값'이된다.
        for(int i = 1 ; i<len; i++){
            if(dp[i-1]>=0) { //이전에 기억했던 정보를 주로 활용한다.
                dp[i] = dp[i - 1] + nums[i];//기억된 정보를 주로 새로운 계산에 활용한다.
            }
            else{//정보를 바탕으로 새롭게 기억될 정보를 정한다.
                dp[i]=nums[i];
            }
            answer= Math.max(answer,dp[i]);
        }
        return answer;
    }
}
