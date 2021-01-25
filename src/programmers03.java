import java.util.ArrayList;

public class programmers03 {
    public static void main(String[] args){

    }
    public static void solution(int[] arr){
        int cnt = arr[0];
        ArrayList<Integer> result=  new ArrayList<>();
        result.add(arr[0]);
        for(int i = 0 ; i< arr.length;i++){
            if(cnt != arr[i]){
                result.add(arr[i]);
                cnt = arr[i];
            }
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i<result.size();i++){
            answer[i] = result.get(i);
        }

    }
}
