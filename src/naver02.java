import java.util.Arrays;

public class naver02 {
    public static void main(String[] args){
        int n = 9;
        int[][] edges = {{0, 2}, {2, 1}, {2, 4},{3, 5}, {5, 4}, {5, 7}, {7, 6},{6, 8}};
        int[][] edges2 = {{0, 2}, {2, 1},{3, 5}, {5, 4}, {7, 6},{6, 8}};
        solution(n,edges);
    }
    public static int[] solution(int n,int[][] edges)
    {
        for(int i =0;i<edges.length;i++){
            for(int j = 0; j< edges.length;j++){
                if(i < j ) {
                    int[] resultCnt = {i,j};

                    //System.out.println(i+" "+j);
                    if(checkNodeCnt(i,j,n,edges)){
                        System.out.println(i+" "+j);
                        return resultCnt;
                    }
                }
            }
        }


        int[] answer = {};
        return answer;
    }
    public static boolean checkNodeCnt(int resultCntI,int resultCntJ,int n,int[][] edges){
        int[] parentNode = new int[n];
        for(int i =0;i<n;i++){
            parentNode[i] = i;
        }
        for(int i = 0 ;i<n;i++) {
            for (int j=0;j< edges.length;j++) {
                int[] edge = edges[j];
                if(j != resultCntI && j != resultCntJ) {
                    if (parentNode[edge[0]] < parentNode[edge[1]]) {
                        parentNode[edge[1]] = parentNode[edge[0]];
                    } else if (parentNode[edge[1]] < parentNode[edge[0]]) {
                        parentNode[edge[0]] = parentNode[edge[1]];
                    }
                }
            }
        }
        int check=0;
        int cnt=parentNode[0];
        for(int parent:parentNode){
            if(parent != cnt){
                if(check != n/3){
                    //System.out.println("틀림"+n/3+" "+check);
                    return false;
                }
                cnt= parent;
                check = 0;
            }
            //System.out.print(parent+""+cnt+""+check+" ");
            check+=1;
        }
        return true;
    }
}
