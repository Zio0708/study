import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class programmers12 {
    public static void main(String[] args){
        System.out.println(solution("oo"));
    }
    public static long solution(String s){
        long[] result = new long[10000];
        Map<Character,Integer> sar= new HashMap<Character,Integer>();
        result[0]=0;
        for(int i = 0 ;i<s.length();i++){
            if(sar.containsKey(s.charAt(i))){
                sar.put(s.charAt(i),sar.get(s.charAt(i))+1);
            }
            else{
                sar.put(s.charAt(i),1);
            }
        }
        for(int i=1;i<=s.length();i++){
            int cnt = 0;
            for(int j = 0;j <i;j++){
                cnt+=j;
            }
            result[i]=result[i-1]+cnt;
            System.out.println(result[i]);
        }
        long answer=result[s.length()];
        Iterator<Character> keys = sar.keySet().iterator();
        while( keys.hasNext() ){
            Character key = keys.next();
            //System.out.println( String.format("키 : %s, 값 : %s", key, sar.get(key)) );
            if(sar.get(key) != 1){
                answer-=result[sar.get(key)];
            }
        }
        return answer;
    }
}
