public class leetcode022503 {
    public String removeOuterParentheses(String S) {
        StringBuilder answer = new StringBuilder();
        int cnt =0;
        for(int i = 0 ; i < S.length(); i ++){
            if(S.charAt(i)=='(' && cnt++ >0) answer.append(S.charAt(i));
            if(S.charAt(i)==')' && cnt-- >1) answer.append(S.charAt(i));
        }
        return answer.toString();
    }
}
