package template;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    static int Ne;
    static int Nv;
    static int[][] ad;
    static boolean[] visit;

    public static void bfs(int i){
        Queue<Integer> q = new <Integer>LinkedList();
        HashMap <Integer, Boolean> hash = new HashMap<Integer, Boolean>();  //hash Map을 이용하여 queue 입력여부 확인

        q.offer(i);

        while(!q.isEmpty()){
            int temp = q.poll();
            visit[temp] = true;
            System.out.print(temp);

            for(int j =1; j <= Ne; j++){
                if(ad[temp][j] == 1 && visit[j] == false){
                    if(!hash.containsKey(j)){
                        q.offer(j);
                        hash.put(j, true);
                    }
                }
            }
        }
    }
}
//알고리즘 템플릿은 직접구현을 우선으로..
