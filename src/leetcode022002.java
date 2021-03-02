public class leetcode022002 {
    public static void main(String[] args){

    }//arithmetic-slices
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        int[][] dp = new int[len][len];
        int answer = 0;
        for(int j = 2;j<len;j++) {
            for (int i = j; i < len; i++) {
                if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                    if(i==j) {
                        dp[j][i] = 1;
                        answer+=1;
                    }
                    else if(dp[j][i-1] ==1){
                        dp[j][i]=1;
                        answer+=1;
                    }
                }
            }
        }
        return answer;
    }
    public int numberOfArithmeticSlices2(int[] A) {
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
            if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }
}
