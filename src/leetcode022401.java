import java.util.Stack;

public class leetcode022401 {
    public static void main(String[] args){

    }
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int cnt;
        for(int i = 1 ; i < len ; i++){
            while(!stack.empty() && T[i] > T[stack.peek()]){
                answer[stack.peek()]= i-stack.pop();
            }
            stack.push(i);
        }
        return answer;
    }
    //
}
