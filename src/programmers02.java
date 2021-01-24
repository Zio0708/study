import java.util.ArrayList;
import java.util.Arrays;

public class programmers02 {
    public static void main(String[] args){

    }
    public static void solution(int[] numbers){
        int[] answer= {};
        ArrayList<Integer> answerAry= new ArrayList<>();
        for(int i = 0 ; i< numbers.length;i++){
            for(int j= 0 ;j< numbers.length;j++){
                if(i!= j && !answerAry.contains(numbers[i]+numbers[j])){
                    answerAry.add(numbers[i]+numbers[j]);
                }
            }
        }
        for(int i = 0 ; i< answerAry.size();i++){
            answer[i] = answerAry.get(i);
        }
        Arrays.sort(answer);
        //return answer;
    }
}
