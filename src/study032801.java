import java.util.ArrayList;
import java.util.List;

public class study032801 {
    static List<String> answer;
    static int check[];
    public static void main(String[] args){
        solution("abcd");
    }
    public static void solution(String s){
        StringBuffer sb;
        answer= new ArrayList<>();

        for(int i = 0; i <  s.length();i++){
            check = new int[26];
            sb = new StringBuffer("");
            dfs(sb,i,s);
        }
        System.out.println(answer.size());
    }

    private static void dfs(StringBuffer sb,int cnt, String s) {
        while(cnt<s.length()){
            sb.append(s.charAt(cnt));
            if(check[s.charAt(cnt)-'a'] == 1){
                return;
            }
            check[s.charAt(cnt)-'a']=1;
            if(!answer.contains(sb.toString())) {
                answer.add(sb.toString());
            }
            cnt++;
        }
    }
}
