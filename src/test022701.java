import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class test022701 {
    static boolean[] visited;
    public static void main(String[] args){

        String skills = "h g f w r";
        int n = 4;
        String[] linked = {"h g", "h f", "g r","g w"};
        solution(skills, n , linked);
        //1. 연계 스킬 구성을 출력하면 되기 때문에 연계 스킬 배열만 봐도 무방하다. (조건 : 단독스킬만 구성되는 스킬은 없다)
        //2. 핵심 : 연계되는 스킬을 중심으로 dfs를 돌린다.
        //3. 조건 1. 단독 스킬에는 선행되는 스킬이 없다. 단독 스킬일 경우에만 스킬 진행이 가능하다.
        //4. 조건 2. 연계가 불가능해지는 경우에만 답을 출력한다.
        //5. 조건 3. 무한 스킬을 방지하기 위해 연계 스킬을 사용시 스킬의 재사용을 막는다.
    }
    private static void solution(String skills, int n, String[] linked) {
        List<List<String>> answer = new ArrayList<>();
        HashSet<String> combo =new HashSet<>();
        visited = new boolean[linked.length];
        for(String combos : linked){
            //조건 1. 단독스킬인지 확인하는 전처리
            combo.add(combos.split(" ")[1]);
        }
        for(int i = 0 ; i< linked.length;i++){//연계 스킬들 중에서~
            if(!combo.contains(linked[i].split(" ")[0])){ //연계스킬이 아니면 = 단독스킬이므로
                visited[i] = true;//조건 3.재사용 금지시키고
                dfs(linked[i].split(" ")[1] , linked,linked[i].split(" ")[0]);//스킬 연계를 타고 들어감
                visited[i] = false;
            }
        }
    }

    private static void dfs(String s, String[] linked,String ans) {
        boolean check =false;
        ans+= " "+s;
        for(int i= 0 ; i< linked.length; i++){
            if(s.equals(linked[i].split(" ")[0]) && !visited[i]){ //조건 2.연계가 가능한경우
                check =true; //조건 2. 지금 상태에서는 연계가 가능하니 정답찍지 말라고 체크
                visited[i] = true; // 조건 3.
                dfs(linked[i].split(" ")[1] , linked,ans);//연계하여 스킬을 진행한다.
                visited[i] = false;
            }
        }
        if(!check) {//조건 2. 더이상 연계할게 없을때만
            System.out.println(ans);//연계 스킬의 정답을 찍어준다.
        }
        return;

    }

}
