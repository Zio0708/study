import java.util.Stack;

public class leetcode022603 {
    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stk = new Stack<>();
        for(int  i = 0 ; i < len ; i++){
            if(s.charAt(i)== ')'){
                //System.out.println(s.charAt(i) +" "+stk.peek());
                if(stk.empty() || stk.pop() != '(') return false;
            }
            else if(s.charAt(i)== ']'){
                //System.out.println(s.charAt(i) +" "+stk.peek());
                if(stk.empty() || stk.pop() != '[') return false;
            }
            else if(s.charAt(i)== '}'){
                //System.out.println(s.charAt(i) +" "+stk.peek());
                if(stk.empty() || stk.pop() != '{') return false;
            }
            else{
                stk.push(s.charAt(i));
            }
        }
        if(stk.empty()){
            return true;
        }
        return false;
    }
}
