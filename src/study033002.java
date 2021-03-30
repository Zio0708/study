import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class study033002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();

            if (".".equals(input)) {

                return;
            }

            System.out.println(isBalanced(input));

        }
    }
    private static String isBalanced (String input){
        char cnt;
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < input.length();i++){
            cnt = input.charAt(i);
            if(cnt =='(') stk.add(cnt);
            else if(cnt =='[') stk.add(cnt);
            else if(cnt ==')'){
                if(stk.isEmpty() || stk.pop() !='(') return "no";
            }
            else if(cnt ==']'){
                if(stk.isEmpty() || stk.pop() !='[') return "no";
            }
        }
        if(stk.isEmpty()) return "yes";
        else return "no";

    }
}
