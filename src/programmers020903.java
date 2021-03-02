import java.util.ArrayList;
import java.util.List;

public class programmers020903 {
    static String[] orderz ;
    static List<String> foodList;
    static List<String> combiList=new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args){
        String[] orders = {"XYZ", "XWY", "WXA"};//{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        solution(orders,course);
    }
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        orderz = orders;
        foodList = makeFood(orders);
        visited = new boolean[foodList.size()];//초기화

        for(int i = 2 ; i <= foodList.size();i++){//모든 주문의 조합식을 구한다.(갯수는 2~10)
            makeCombi(0, i);
        }
        //코스의 갯수마다 주문 조합을 꺼낸다.
        //주문 조합을 대입시키면서 각각의 오더와 비교한다.
        //사람이 2명 이상인 경우에 리스트에 집어넣는다.
        //리스트를 소트하여 반환한다.
        return answer;
    }

    private static List<String> makeFood(String[] orders) {
        List<String> foodList = new ArrayList<>();
        for(String order : orders){
            for(int i =  0 ; i < order.length();i++) {
                String food = order.substring(i,i+1);
                if (!foodList.contains(food)) {
                    foodList.add(food);
                }
            }
        }
        return foodList;
    }

    private static void makeCombi(int start , int r) {
        //조합은 백트래킹으로 구한다.
        //start = 탐색의 시작부분
        //r개를 줄여가면서 조합을 뽑는다.
        if(r==0){
            String combi="";
            for(int i = 0;i < visited.length;i++){
                if(visited[i]){
                    combi+=foodList.get(i);
                }
            }
            combiList.add(combi);
            return;
        }
        for(int i = start ; i < foodList.size() ; i++){
            visited[i] = true;
            makeCombi(i+1,r-1);
            visited[i] = false;
        }

    }
}
