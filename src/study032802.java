import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class study032802 {
    public static void main(String[] args){
        solution(3,new int[]{4,2,2,5,3});
    }
    public static void solution(int N, int[] coffee_times){
        PriorityQueue<Coffee> order = new PriorityQueue<Coffee>();
        List<Integer> answer = new ArrayList<>();
        int[] ans= new int[coffee_times.length];
        long time=0;
        int cnt=0;
        while(cnt < coffee_times.length) {
            if(order.size() != N){//모든 커피 주문이 돌때까지
                order.add(new Coffee(cnt+1, coffee_times[cnt]+time)); // 커피를 집어넣는다.
                System.out.println("커피 투입"+ (cnt+1) +" "+ (coffee_times[cnt]+time));
                cnt++;
            }
            //모두 넣었다면
            else {
                //가장 빨리 걸리는 시간만큼 시간을 더한다.
                time = order.peek().time;
                long check = order.peek().time;//가장 빨리 끝나는 커피주문을 뽑는다.
                while(!order.isEmpty() && check == order.peek().time) {
                    System.out.println("아웃"+order.peek().name+" "+time);
                    answer.add(order.poll().name);
                }
            }
        }
        while(!order.isEmpty()) { //남은 커피주문을 계산한다.
            time = order.peek().time; //가장 빨리 끝나는 커피주문을 뽑는다.
            long check = order.peek().time;
            while(!order.isEmpty() && check == order.peek().time) {
                System.out.println("아웃"+order.peek().name+" "+time);
                answer.add(order.poll().name);
            }
        }
        for(int i = 0 ; i < answer.size();i++){
            System.out.print(answer.get(i)+" ");
            ans[i]=answer.get(i);
        }
    }


}
class Coffee implements Comparable<Coffee>{
    int name;
    long time;
    public Coffee(int name, long time) {
        this.name = name;
        this.time = time;
    }
    public int compareTo(Coffee o) {
        if(this.time == o.time){
            return this.name-o.name;
        }
        return (int)(this.time - o.time);
    }
}
