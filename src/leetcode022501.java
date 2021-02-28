import java.util.Stack;

public class leetcode022501 {
    public static void main(String[] args){
        String s = "3[a]2[bc]";
        decodeString(s);
    }
    public static String decodeString(String s) {
        int len = s.length();
        int cnt = 0;
        String alpa = "";
        Stack<Integer> numStk = new Stack<>();
        Stack<String> alpaStk = new Stack<>();
        //3가지 경우의 수
        //숫자일 경우. 숫자를 통째로 집어넣는다
        //] 일경우. [가 나올때까지 스택에서 뽑는다.
        //문자일 경우 스택에 넣는다.
        //[일 경우도 일단 스택에 넣음
        while(cnt < len){
            if(Character.isDigit(s.charAt(cnt))){
                int num=0;
                while(Character.isDigit(s.charAt(cnt))){
                    num += 10 * num + (s.charAt(cnt)-'0');
                    cnt++;
                }
                numStk.push(num);
            }
            else if(s.charAt(cnt) == '['){
                alpaStk.push(alpa);
                alpa="";
                cnt++;
            }
            else if(s.charAt(cnt) == ']'){
                StringBuilder sb= new StringBuilder(alpaStk.pop());
                int numLen =numStk.pop();
                for(int i = 0 ;i<numLen ; i++){
                    sb.append(alpa);
                }
                alpa= sb.toString();
                cnt++;
            }
            else{
                alpa+=s.charAt(cnt++);
            }

        }
        return alpa;
    }
}
