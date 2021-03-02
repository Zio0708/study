public class programmers10 {
    static long answer = 0;
    public static void main(String[] args){
        solution("abcab");
    }
    public static long solution(String s) {
        for(int i = 0 ;i<s.length();i++) {
            int cnt = i+1;
            int[] result = new int[s.length()];
            result[i]=0;
            while (cnt < s.length()) {
                System.out.println(s.charAt(i)+" "+s.charAt(cnt));
                if (s.charAt(i) == s.charAt(cnt)) {
                    result[cnt] = result[cnt - 1];
                } else {
                    result[cnt] = cnt-i;
                }
                System.out.println(result[cnt]);
                answer += result[cnt];
                cnt += 1;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
