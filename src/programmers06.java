public class programmers06 {
    public static void main(String[] args){

    }
    public static double solution(int[] arr){
        double answer= 0;
        for(int ar : arr){
            answer += ar;
        }
        answer = answer / arr.length;
        return answer;
    }
}
