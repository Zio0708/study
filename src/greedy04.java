import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class greedy04 {
    public static void main(String[] args){
        int n = 4;
        int[][] costs = {{0, 1, 1},{2, 0, 2},{1, 2, 5}, {1, 3, 1},{2, 3, 8}};
        solution(n, costs);
    }
    public static void solution(int n , int[][] costs){
        int answer = 0 ;
        int cnt = 0;
        ArrayList<Integer> nodes= new ArrayList<>();
        ArrayList<int[]> costsAry = new ArrayList<>();
        Arrays.sort(costs,(a, b)-> Integer.compare(a[2],b[2]));
        for(int[] cost:costs){
            costsAry.add(cost);
        }
        nodes.add(costs[0][0]);
        nodes.add(costs[0][1]);
        answer+=costs[0][2];
        while(nodes.size()<n) {
            for (int[] cost : costsAry) {
                if (nodes.contains(cost[0]) && nodes.contains(cost[1])) {
                    continue;
                }
                else if (nodes.contains(cost[0]) && !nodes.contains(cost[1])) {
                    nodes.add(cost[1]);
                    answer += cost[2];
                    System.out.println(cost[0]+" "+cost[1]+"/"+cost[2]);
                }
                else if (nodes.contains(cost[1]) && !nodes.contains(cost[0])) {
                    nodes.add(cost[0]);
                    answer += cost[2];
                    System.out.println(cost[0]+" "+cost[1]+"/"+cost[2]);
                }
            }
        }
        System.out.println(answer);
    }
}
