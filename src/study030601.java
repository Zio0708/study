public class study030601 {
    public static int[] parent = new int[1000001];
    public static void main(String[] args){
        //union find 알고리즘
        //공통 부모를 찾는데 매우 좋은 알고리즘
        //크루스칼 알고리즘
        //최저 비용으로 모든 노드를 연결하기에 좋은 알고리즘
        //다익스트라
        //최저 비용으로 노드에서 노드까지 비용 계산하는 알고리즘
        //공통 조상 문제
        //다익스트라를 이용하여 깊이를 구한다음 깊이를 올려가면서 공통 조상이 나오면 체크한다.

    }
    public static int find(int x){
        if(x==parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y){
        x=find(x);
        y=find(y);
        if(x!=y){
            if(x<y) parent[y]=x;
            else parent[x]=y;
        }
    }
    public static boolean sameParent(int x , int y){
        if(find(x) ==find(y)) return true;
        return false;
    }
    //여기까지가 union find 구현
    class Edge implements Comparable<Edge> {
        int v1,v2,cost;
        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            if(this.cost < o.cost)
                return -1;
            else if(this.cost == o.cost)
                return 0;
            else
                return 1;
        }
    }//크루스칼에 필요한 edge구현(굳이 edge 클래스 만들어야하나?)
    //크루스칼의 기본:
    public static void kruskal(){
        for(int i = 0; i< 10;i++){
            //Edge edge = edgeList.get(i); 비용 저렴한거부터 가져와서
            //if(!isSameParent(edge.v1, edge.v2)) { 각 노드의 조상이 같으면 할 필요 없으니 거르고
            //    sum += edge.cost; 비용 저렴한 순이니 바로 더한다
            //    union(edge.v1, edge.v2); 그리고 간선을 연결시켜준다.
            //}
        }
    }

}
