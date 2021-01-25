public class programmers04 {
    public static void main(String[] args){

    }
    public static int solution(int a, int b){
        if(a>b){
            int cnt = a;
            a = b;
            b= cnt;
        }

        int result = 0;
        for(int i = a ; i<= b; i++ ){
               result+=i;
        }
        return result;
    }
}
