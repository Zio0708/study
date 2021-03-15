import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class backjoon031504 {
    static int n;
    static int m;
    static int start;
    static int end;
    static ArrayList<Node> list[];
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //st=new StringTokenizer(br.readLine());
        n =Integer.parseInt(br.readLine());
        m =Integer.parseInt(br.readLine());
        list= new ArrayList[n+1];
        dist= new int[n+1];
        visited  = new boolean[n+1];//체크용
        for(int i =0; i<=n;i++){
            list[i]= new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);//채워넣기
        int a,b,len;
        for(int i =0; i<m;i++){
            st= new StringTokenizer(br.readLine());
            a =Integer.parseInt(st.nextToken());
            b =Integer.parseInt(st.nextToken());
            len =Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,len));
        }
        st=new StringTokenizer(br.readLine());
        start =Integer.parseInt(st.nextToken());
        end =Integer.parseInt(st.nextToken());
        dist[start]=0;
        solution();
        System.out.println(dist[end]);
        return;
    }
    public static void solution(){
        PriorityQueue<Node> pq =new PriorityQueue<>();
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node cnt =pq.poll();
            if(visited[cnt.name]){
                continue;
            }
            visited[cnt.name]= true;
            for(Node cn :list[cnt.name]){
                if(dist[cn.name] > dist[cnt.name]+cn.len){
                    dist[cn.name] = dist[cnt.name]+cn.len;
                    pq.add(new Node(cn.name,dist[cn.name]));
                }
            }
        }
    }
    static class Node implements Comparable<Node>{
        int name,len;
        Node(int name,int len){
            this.name= name;
            this.len= len;
        }
        @Override
        public int compareTo(Node cnt) {
            return this.len - cnt.len;
        }
    }

}
