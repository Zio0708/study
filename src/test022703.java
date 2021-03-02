public class test022703 {
    //땅콩의 시작위치 e 를 기준으로 location[n]을 left = n , location[n+1]을 right = n+1로 정함
    //땅콩의 갯수를 세면서 e-left 와 right-e를 비교해서 더 작은 쪽의 포인터를 이동
    //왜 더 작은쪽으로 가냐 -> 한개씩 땅콩을 골라먹을때 가까운거만 집어먹어도 답이 나온다.
    //갯수가 m이 되면 종료하고 location[right] - location[left]으로 이동 거리를 구함.
    public static void main(String[] args) {
        System.out.println(solution(3,7,new int[]{2,4,5,8,11,12}));
    }
    private static int solution(int m, int e, int[] location) {
        //
        int len =location.length;
        if(e <=location[0]){
            return location[m-1]-e;
        }
        if(e >= location[len-1]){
            return e- location[len-m];
        }
        int left=0;
        int right=0;
        for(int i = 0 ; i <len-1 ; i ++){
            if(location[i]==e){ left=i; right=i;}
            else if(location[i]< e && location[i+1]>e){ left=i; right=i+1;}
        }
//        while(cnt < m){
//
//        }
        System.out.println(location[right]+"답"+location[left]);
        return location[right]-location[left];
    }
    //투 포인터를 활용하려 했으나 시작지점이 포인터가 아니기 때문에 미묘해짐
}
