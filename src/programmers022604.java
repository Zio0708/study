import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class programmers022604 {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hsh = new HashSet<>();
        int len = numbers.length;
        for(int i = 0 ; i < len ; i++){
            for(int j = i ; j<len;j++){
                hsh.add(numbers[i]+numbers[j]);
            }
        }
        Iterator<Integer> it = hsh.iterator(); // Iterator(반복자) 생성
        int[] answer = new int[hsh.size()];
        int cnt=0;
        while (it.hasNext()) { // hasNext() : 데이터가 있으면 true 없으면 false
            answer[cnt++] = it.next(); // next() : 다음 데이터 리턴
        }
        Arrays.sort(answer);
        return answer;
    }
}
