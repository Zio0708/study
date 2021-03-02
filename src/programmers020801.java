import java.util.LinkedList;
import java.util.List;

public class programmers020801 {
    static List<String> numbers = new LinkedList<>();
    static List<String> cals = new LinkedList<>();
    static int[][] cal = {{1,2,3},{1,3,2},{2,1,3},{2,3,1},{3,1,2},{3,2,1}};
    public static void main(String[] args){
        String expression = "100-200*300-500+20";
        solution( expression);
    }
    public static long solution(String expression) {
        //수식을 잘라서 담는 방법
        //숫자와 수식 리스트를 만든다.
        //for문을 돌면서 글자를 하나씩 체크
        //cnt에 숫자를 하나씩 담다가 문자가 나오면 끊고 숫자 리스트에 추가
        //문자가 나오면 문자 리스트에 추가


        long answer= 0l;
        for(int i = 0 ; i < cal.length;i++){
            numbers= new LinkedList<>();
            cals=new LinkedList<>();
            makeAry(expression);
            answer = Math.max(answer,Math.abs(calAnswer(cal[i])));
        }
        System.out.println(answer);
        return answer;
    }

    private static long calAnswer(int[] ints) {
        for(int i = 0 ; i < ints.length;i++){
            //System.out.println(ints[i]);
            if(ints[i]==1){
                calmul();
                //System.out.print(numbers.get(0));
            }
            else if(ints[i]==2){
                caladd();
                //System.out.print(numbers.get(0));
            }
            else if(ints[i]==3){
                calmin();
                //System.out.print(numbers.get(0));
            }

        }
        return Long.parseLong(numbers.get(0));
    }

    private static void calmul() {
        while(cals.indexOf("*") != -1){
            int cnt =  cals.indexOf("*");
            long mul= Long.parseLong(numbers.get(cnt)) * Long.parseLong(numbers.get(cnt+1));
            String answer= Long.toString(mul);
            numbers.set(cnt,answer);
            numbers.remove(cnt+1);
            cals.remove(cnt);
        }
    }
    private static void calmin() {
        while(cals.indexOf("-") != -1){
            int cnt =  cals.indexOf("-");
            long mul= Long.parseLong(numbers.get(cnt)) - Long.parseLong(numbers.get(cnt+1));
            String answer= Long.toString(mul);
            numbers.set(cnt,answer);
            numbers.remove(cnt+1);
            cals.remove(cnt);
        }
    }
    private static void caladd() {
        while(cals.indexOf("+") != -1){
            int cnt =  cals.indexOf("+");
            long mul= Long.parseLong(numbers.get(cnt)) +Long.parseLong(numbers.get(cnt+1));
            String answer= Long.toString(mul);
            numbers.set(cnt,answer);
            numbers.remove(cnt+1);
            cals.remove(cnt);
        }
    }

    private static void makeAry(String expression) {
        String number="";
        for(int i = 0 ; i < expression.length();i++){
            String cnt=expression.substring(i,i+1);
            //System.out.println(cnt);
            if(cnt.equals("*") ||cnt.equals("+")||cnt.equals("-")){
                numbers.add(number);
                cals.add(cnt);
                number="";

            }
            else{
                number+=cnt;
            }
        }
        numbers.add(number);
    }
}
