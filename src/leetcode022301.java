public class leetcode022301 {
    public static void main(String[] args){

    }
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        String left= "";
        String right="";
        x = Math.abs(x);
        String cnt= Integer.toString(x);
        for(int i = 0 ;  i < cnt.length();i++){
            left += cnt.substring(i,i+1);
            right+= cnt.substring(cnt.length()-1-i,cnt.length()-i);
        }
        if(left.equals(right)) {
            return true;
        }
        return false;
    }
}
