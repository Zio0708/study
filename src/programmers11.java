public class programmers11 {
    public static void main(String[] args){
        System.out.println(solution(45));
    }
    public static int solution(int n){
        int answer = 0;
        int target = n;
        int temp = 0;
        int cnt = 0;
        int[] arr = new int[1000];

        while(target > 0){

            temp = target/3;
            arr[cnt++] = target%3;
            target = temp;

        }
        arr[cnt] = temp;

        temp = 0;

        while(cnt >= 0){

            answer += Math.pow(3,temp++) * arr[cnt--];

        }

        return answer;
    }
}
