public class programmers030402 {
    static int[] dial = {6,2,5,5,4,5,6,3,7,6};
    static int answer=0;
    static int kk;
    static public void main(String[] args){
        System.out.println(solution(1));
    }
    public static int solution(int k) {
        kk=k;
        for(int i =0 ; i<dial.length;i++){
            dfs(dial[i],1);
        }
        return answer;
    }
    private static void dfs(int cnt,int zero) {
        if(cnt == kk && zero != 0) {
            answer+=1;
            return;
        }
        if(cnt > kk) return;
        for(int i = 0; i<dial.length;i++){
            dfs(cnt+dial[i],i);
        }
    }
}
