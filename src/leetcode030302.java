import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class leetcode030302 {
    static boolean answer;
    static boolean[] check;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        check = new boolean[numCourses];
        int len = prerequisites.length;
        answer= false;
        for(int i = 0 ; i <len;  i++){
            if(!check[prerequisites[i][0]]){
                check[prerequisites[i][0]]= true;
                System.out.println(prerequisites[i][0]);
                dfs(numCourses,prerequisites,prerequisites[i][1],1);
                check[prerequisites[i][0]]= false;
            }
        }
        return answer;
    }

    private void dfs(int numCourses, int[][] prerequisites, int back, int cnt) {
        if(cnt== numCourses){
            System.out.println("정답");
            answer= true;
            return;
        }
        for(int i = 0 ; i < prerequisites.length;  i++){
            if(back == prerequisites[i][0] && !check[prerequisites[i][0]] ){
                check[prerequisites[i][0]]= true;
                System.out.println(prerequisites[i][0]);
                dfs(numCourses,prerequisites,prerequisites[i][1],cnt+1);
                check[prerequisites[i][0]]= false;
            }
        }

    }
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
        if(visited[course])
            return false;
        else
            visited[course] = true;;

        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }
    //1번 문제. 각각의 노드에서 갈수있는 스킬들을 방문한느 것임
    //2번 문제. 시간 부족을 방지하기위해 사이클이 등록된 것은 아예 접근을 하지 않는다.
}
