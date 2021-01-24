public class programmers01 {
    public static void main(String[] args){
        String s= "abcabcabcabcdededededede";
        String b= "xababcdcdababcdcd";
        String c = "ababababababababababababababababababab";
        solution(c);
    }
    public static void solution(String s){
        int sLen = s.length();
        int minResult = 1000;
        int result =0;
        for(int i =1;i<=sLen/2;i++){
            System.out.println(i+"시작");
            result = checkLen(s,i);
            System.out.println(result);
            if(result<minResult){
                minResult = result;
            }
        }
        System.out.println(minResult);
    }
    public static int checkLen(String s, int i){
        boolean checkSame= false;
        int checkSecond =0;
        int cnt = 0;
        int result = s.length();
        int minResult=1000;
        while(cnt+(2*i) <= s.length()) {
            if(s.subSequence(cnt, cnt + i).equals(s.subSequence(cnt+i, cnt + (2*i)))){
                if(checkSecond != 0){
                    result-=i;
                    checkSecond +=1;
                    System.out.println("중복");
                }
                else if(checkSecond == 0){
                    result-=i;
                    checkSecond =2;
                    System.out.println("겹침");
                }
            }
            else{
                if(checkSecond != 0) {
                    int checkLen = String.valueOf(checkSecond).length();
                    System.out.println(checkLen);
                    result += checkLen;
                }
                checkSecond=0;
            }
            cnt+=i;
        }
        if(checkSecond != 0) {
            int checkLen = String.valueOf(checkSecond).length();
            System.out.println(checkLen);
            result += checkLen;
        }
        //System.out.println(result);
        if(minResult>result){
            minResult=result;
        }
        return result;
    }
}
