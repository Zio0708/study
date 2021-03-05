import java.util.Stack;

public class study030503 {
    static int[][] mapz;
    static int kz;
    static int answer=0;
    public static void main(String[] args){
        int[][] map = {{2 ,2, 2,},
                {4, 4, 4},
                {8, 8, 8}};
        solution(map,5);
    }
    public static void solution(int[][] map, int k){
        mapz =map;
        kz=k;
        //dfs를 통해 k번동안 움직이는 모든 조합을 계산한다
        //그중에 가장 높은 값이 있으면 저장
        //answer은 k번일때 가장 높은 값을 저장시킴

        //문제를 부분 문제로 나누어서 계산한다.
        //1. 방향을 지정하는 문제 dfs
        //2. 방향에 따라 범위를 지정
        //3. 범위에 따라 겹치는 문제

        for(int i = 0 ; i< 4; i ++){
            dfs(0,1);//방향과 이동 횟수를 전달
        }
    }

    private static void dfs(int dir, int cnt) {
        //방향 지정: 오른쪽부터 i0 ~ i3
        //아래 : 0i~3i
        //왼 : i3:i0
        //위 : 3i:0i

        //스택 쌓기
        Stack<Integer> stk =new Stack<>();
        boolean check=true;
        for(int i = 0 ; i < 4; i++){
            if(!stk.empty() && check && stk.peek() == mapz[0][i]){
                stk.pop();
                stk.push(mapz[0][i] *2);
                answer = Math.max(answer, mapz[0][i]*2);
                check=false;
            }
            else if(mapz[0][i] != 0){
                stk.push(mapz[0][i]);
                answer = Math.max(answer, mapz[0][i]);
                check=true;
            }
        }


        if(cnt == kz) return;
        for(int i = 0 ; i< 4; i ++){
            dfs(0,1);//방향과 이동 횟수를 전달
        }

    }
}
