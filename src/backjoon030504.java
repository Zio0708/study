import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon030504 {
    static int n;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int r = Integer.parseInt(str[2]);
        graph = new int[n+1][n+1];
        int max = Integer.MIN_VALUE;

        String[] num = br.readLine().split(" ");
        int[] numArr = new int[n+1];
        for(int i=1; i<=n; i++)
            numArr[i] = Integer.parseInt(num[i-1]);

        for(int i=0; i<r; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            graph[start][end] = cost;
            graph[end][start] = cost;
        }

        for(int i=1; i<=n; i++) {
            int[] distance = dijkstra(i);
            int sum = 0;
            for(int j=1; j<=n; j++) {
                if(distance[j]<=m)
                    sum+=numArr[j];
            }

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

    private static int[] dijkstra(int v) {//다익스트라 알고리즘
        int[] distance = new int[n+1];//길이저장
        boolean[] visited = new boolean[n+1];//방문저장

        for(int i = 1; i<= n; i++){//최대값초기화
            distance[i]=Integer.MAX_VALUE;
        }
        distance[v]=0;//v부터 시작초기화
        visited[v]=true;
        for(int i=1; i<=n; i++) {//방문한적 없고 이어져있으면 구간 기록
            if(!visited[i] && graph[v][i]!=0) {
                distance[i] = graph[v][i];
            }
        }
        for(int i=0; i<n-1; i++) {//다른 라인을 돌면서
            int min = Integer.MAX_VALUE;
            int index = 0;//인덱스에 따라 이동

            for(int j=1; j<=n; j++) {
                if(!visited[j] && distance[j]!=Integer.MAX_VALUE) {//방문안했으면서 , 최대길이가 아닌경우
                    if(distance[j]<min) { //최소인경우
                        min = distance[j];//업데이트
                        index = j;//인덱스 이동
                    }
                }
            }

            visited[index] = true;

            for(int j=1; j<=n; j++) {
                if(!visited[j] && graph[index][j]!=0) {
                    if(distance[j]>distance[index] + graph[index][j])
                        distance[j] = distance[index] + graph[index][j];
                }
            }
        }
        return distance;
    }
}//이거 별로 다익스트라 치고 안깔끔함
