import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class backjoon031503 {
    static int v,e,k;
    static ArrayList<Node> list[];
    static int dist[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] t = br.readLine().split(" ");
        v = Integer.parseInt(t[0]);//노드
        e = Integer.parseInt(t[1]);//간선
        dist = new int[v+1];//거리
        list = new ArrayList[v+1];//경우의 수
        visited = new boolean[v+1];//체크용
        for(int i=1; i<=v; i++) {
            list[i] = new ArrayList<>();//경우의 수 받기위해 새로만들기
        }
        Arrays.fill(dist, Integer.MAX_VALUE);//채워넣기
        k = Integer.parseInt(br.readLine());    // 시작번호
        for(int i=0; i<e; i++) {
            String [] tt = br.readLine().split(" ");
            int a = Integer.parseInt(tt[0]);    //노드1
            int b = Integer.parseInt(tt[1]);    //노드2
            int w = Integer.parseInt(tt[2]);    // 거리
            list[a].add(new Node(b,w));
        }
        dist[k]=0;//초기화
        solution();
        for(int i=1; i<=v; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(dist[i]);
            }
        }

    }
    public static void solution(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k,0));//k를 정점으로 하는 노드생성
        while(!pq.isEmpty()){//큐가 빌때까지
            Node a = pq.poll();//노드를 꺼내면서
            if(visited[a.idx]){
                continue;
            }
            visited[a.idx]= true;
            for(Node o : list[a.idx]){//방문하지 않았을경우
                if(dist[o.idx]>dist[a.idx]+o.w){//거리가 더 가까운경우
                    dist[o.idx]=dist[a.idx]+o.w;//바꿔넣고
                    pq.add(new Node(o.idx,dist[o.idx]));//다음 노드로 전진
                }
            }
        }
    }
    static class Node implements Comparable<Node>{
        int idx,w;
        Node(int idx,int w){
            this.idx=idx;
            this.w=w;
        }
        public int compareTo(Node o) {
            return this.w-o.w;
        }
    }

}

