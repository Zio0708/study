public class leetcode021806 {
    //is-subsequence
    public static void main(String[] args){
        isSubsequence("a","b");
    }
    public static boolean isSubsequence(String s, String t) {
        int count = s.length();
        int cnt=0;
        if(s.length()==0 ){
            return true;
        }
        if(t.length()==0){
            return false;
        }
        for(int i = 0 ; i < t.length(); i++){
            if(s.charAt(cnt)== t.charAt(i)){
                cnt+=1;
            }
            if(cnt == count){
                return true;
            }
        }
        return false;
    }
}
