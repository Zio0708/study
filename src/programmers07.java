import java.util.HashMap;
import java.util.Map;

public class programmers07 {
    public static void main(String[] args){
        long k= 	10;
        long[] room_number = {1, 3, 4, 1, 3, 1};
    }
    public static void solution (long k , long[] room_number){
        Map<Integer,Integer> reserve = new HashMap<Integer, Integer>();
        long[] answer = new long[room_number.length];
        for(int i =0  ;i< room_number.length;i++){
            if(reserve.containsKey(room_number[i])){

            }
            else{
                //reserve.put(room_number[i],);
                //reserve[i] = room_number[i];
            }
        }
    }
}
