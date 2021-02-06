import java.util.List;

public class programmers08 {
    public static void main(String[] args){
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        solution(stones,k);
    }
    public static int solution(int[] stones, int k) {
        int answer = 0;
        int left =  stones[0];
        int right =  stones[0];
        int mid=0;
        for(int stone :stones){
            left=Math.min(stone,left);
            right=Math.max(stone,right);
        }
        while(left<=right){
            mid= (left+right)/2;
            System.out.println(mid);
            if(check(stones,mid,k))//mid 징검다리를 못건너면
            {
                left= mid +1;
                answer = Math.max(answer,mid);

            }
            else{//mid로 건너진다
                right=mid-1;
            }
        }
        return answer;
    }
    private static boolean check(int[] stones, int mid, int k) {
        //연속으로 k번 0이하가 되면 탈락
        int fail=0;
        for(int i=0; i < stones.length;i++){
            //System.out.print(stones[i]-mid + " ");
            if(stones[i]-mid <=0){
                fail+=1;
                //System.out.println("fail:" +fail);
            }
            else{
                fail=0;
            }
            if(fail >= k){
                return false;
            }
        }
        return true;
    }
}
