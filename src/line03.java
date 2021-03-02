import java.util.Arrays;
import java.util.HashMap;

public class line03 {

    static int[][] fire;
    static HashMap<String,Integer> receipe = new HashMap<>();
    static int cookTime=0;
    static int resultTime = 0;
    public static void main(String[] args){
        int[][] line =new int[2][2];
        solution(line);
    }

    private static void solution(int[][] line) {
    }

    public int solution(int n, String[] recipes, String[] orders) {
        fire= new int[n][50000];
        int orderLen = orders.length;
        int orderCnt=0;

        for(String r : recipes){
            receipe.put(r.split(" ")[0],Integer.parseInt(r.split(" ")[1]));
            System.out.println();
        }
        cookTime =  Integer.parseInt(orders[0].split(" ")[1]);//주문시간
        while(orderCnt<orderLen){
            //화구가 비었는지 체크 후 비어있으면 위에부터 주문 집어넣음.
            String orderFood = orders[orderCnt].split(" ")[0];//주문음식
            String orderTime = orders[orderCnt].split(" ")[1];//주문시간
            boolean checkUpdate =false;
            //조리가 주문보다 빨리 끝났을때 -> 바로 다음 조리.
            //주문이 밀렸을때 -> 조리가 끝날때까지 기다림.
            int checkEndTime=50001;
            for(int i=0; i<n;i++) {
                if (check(fire[i])){
                    sendOrder(fire[i],orderTime);//비어있으면 현재 시간에 주문 넣고 break
                    checkUpdate= true;
                    break;
                } else {
                    checkEndTime=Math.min(checkEndTime,endTimeCheck(fire[i]));//모두 안비어있으면 가장 짧게 끝날때까지 cookTime 이동후 다시 체크.
                }
            }
            if(checkUpdate) {//주문이 들어갔으면
                orderCnt++;//다음주문으로 이동.
            }
            else{//실패하면
                cookTime = checkEndTime;//주문 완료 시간으로 이동
            }
        }

        int answer = 0;
        return answer;


    }

    private int endTimeCheck(int[] ints) {
        int cnt = cookTime;
        while(ints[cnt] != 1){
            cnt+=1;
        }
        return cnt;
    }

    private void sendOrder(int[] ints,String orderFood) {
        int time = receipe.get(orderFood);
        resultTime = Math.max(resultTime,cookTime+time);
        for(int i = cookTime ;i<cookTime+time;i++){
            ints[i] = 1;
        }
    }

    private boolean check(int[] ints) {
        if(ints[cookTime] == 1){
            return false;
        }
        return true;
    }
}
