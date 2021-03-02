import java.util.List;

public class leetcode021901 {
    //word-break
    static boolean answer;
    static int[] dp ;
    public static void main(String[] args){

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        //구해야 하는것 : s가 wordict의 조합으로 만들어질 수 있는지
        //저장해야 하는것 :
        int len = s.length();
        dp = new int[len+1]; //여기부터 시작할때 되는지 체크
        answer= false;
        for(int  j = len ; j >0; j-- ){
            if(wordDict.contains(s.substring(0,j)) && dp[j] != -1){
                dfs(j,s,wordDict);
            }
        }
        return answer;
    }

    private void dfs(int j, String s, List<String> wordDict) {
        if(j == s.length()){
            answer =true;
            return;
        }
        int len = s.length();
        for(int  x = len ; x >j; x-- ){
            if(wordDict.contains(s.substring(j,x)) && dp[x] != -1){
                dfs(x,s,wordDict);
            }
        }
        dp[j] = -1;
    }
    //실패원인: 뭐를 저장해야 하는지 구분하지 못함.
    //어떤 것으로 구분해야 하는지? 에 대한 확실한 근거로 구분하여야 한다.
    //안되는 경우의 수도 저장해야 한다는 마음가짐을 가져야 한다.
}
