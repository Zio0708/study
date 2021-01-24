public class programmers01after {
    public static void main(String[] args){
        String s= "abcabcabcabcdededededede";
        solution(s);
    }

    private static int solution(String s) {
        //1.글자를 단위별로 나눈다.
        //1-1.최소 길이는 글자 길이 1~ 글자 길이의 절반까지.
        //2.글자를 이전 글자와 비교한다.
        //3.이전 글자와 처음 일치하면 숫자 2를 넣는다.
        //4.이전 글자와 계속 일치하면 숫자에 1을 더한다.
        //5.결과 값은 글자 길이 - 중복 글자 자릿수 + 중복 숫자 자릿수
        //6.최소인 결과 값을 비교하여 최종 값을 구한다.
        int answer = s.length();
        if(s.length() == 1){
            return 1;
        }
        for(int i = 1 ; i<= s.length()/2 ; i++){
            //System.out.println(i+"로 나눔");
            if(answer>compare(s,i)){
                answer = compare(s,i);
            }
        }
        System.out.println(answer);
        return answer;
    }
    private static int compare(String s, int i) {
        String firstS;
        String secondS;
        int length = s.length();
        int checkLen = 0;
        int cnt=0;
        while(cnt+2*i <= s.length()){
            firstS = String.valueOf(s.subSequence(cnt,cnt+i));
            secondS = String.valueOf(s.subSequence(cnt+i,cnt+2*i));
            //System.out.println(firstS +" "+secondS);
            if(firstS.equals(secondS) && checkLen ==0){
                length-= i;
                checkLen =2;
            }
            else if(firstS.equals(secondS) && checkLen !=0){
                length-= i;
                checkLen+=1;
            }//중복 체크
            else{
                if(checkLen !=0) {
                    //System.out.println("중복정산");
                    int minus = String.valueOf(checkLen).length();
                    length += minus;
                }
                checkLen=0;
            }
            cnt += i;
        }
        if(checkLen !=0) {
            //System.out.println("중복정산");
            int minus = String.valueOf(checkLen).length();
            length += minus;
        }
        checkLen=0;
        //System.out.println(length);
        return length;
    }
}
