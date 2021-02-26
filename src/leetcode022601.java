import java.util.Stack;

public class leetcode022601 {
    public String removeDuplicates(String S) {
        int len = S.length();
        Stack<Character> stk = new Stack<>();
        stk.push(S.charAt(0));
        for(int i = 1 ; i < len ; i ++){
            if(!stk.empty() && S.charAt(i) == stk.peek())stk.pop();
            else stk.push(S.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stk) {
            sb.append(c);
        }
        return sb.toString();
    }

}
