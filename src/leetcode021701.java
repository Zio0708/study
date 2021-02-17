import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode021701 {
    static List<List<String>> answer;
    static boolean[][] check;
    public static void main(String[] args){
        partition("aab");
    }

    public static List<List<String>> partition(String s) {
        answer =new ArrayList<>();
        check = new boolean[s.length()][s.length()];
        for(boolean[] cnt :check){
            Arrays.fill(cnt,false);
        }
        //dfs지만 visited와 같은 역할을 하는 dp를 만들어줘야 함
        //일단 dfs를 만들어주자.
        //visited가 아니면 체크하고 다음칸으로
        //visited이면
        dfs(0,new ArrayList<String>(),s);
        return answer;
    }

    private static void dfs(int i, ArrayList<String> ary, String s) {

        if(i == s.length()){
            answer.add(new ArrayList<>(ary));
            return;
        }
        for(int j = i ; j < s.length();j++){

            if(checkPalin(s,i,j) ) {
                //System.out.println(i+"반복"+j);
                check[i][j] = true;
                ary.add(s.substring(i,j+1));
                dfs(j+1,ary,s);
                ary.remove(ary.size()-1);
            }
        }
        return;
    }

    private static boolean checkPalin(String s,int i,int j) {
        if(i == j){
            return true;
        }
        if(s.charAt(i) == s.charAt(j)){
            if(j-i ==1){
                return true;
            }
            else if(check[i+1][j-1]){
                return true;
            }
            return false;
        }
        return false;
    }

}
