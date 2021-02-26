import java.util.ArrayList;
import java.util.List;

public class leetcode022602 {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        //뒤에서 부터 비교하면서
        //1.해당 숫자와 맞지 않으면 : 넣고 바로 뺀것
        //2.해당 숫자와 일치하면  : 넣은것
        int j=0;
        for (int i=1;i<=n && j<target.length;i++) {
            result.add("Push");
            if(target[j]==i) {
                j++;
            } else {
                result.add("Pop");
            }
        }
        return result;

    }
}
