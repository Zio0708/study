public class programmers05 {
    static int answer=0;
    public static void main(String[] args){
        solution(3);
    }
    public static int solution(int n){
        DFS(1,1,2*n);
        System.out.println(answer);
        return answer;
    }
    public static void DFS(int cnt,int go, int n){
        //System.out.println(go);
        if(go == n){
            if(cnt == 0) {
                //System.out.println(cnt);
                answer += 1;
            }
            return;
        }
        if(cnt<0){
            return;
        }
        DFS(cnt+1,go+1,n);
        DFS(cnt-1,go+1,n);
        return;
    }
}
