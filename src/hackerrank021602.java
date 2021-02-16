import java.util.List;

public class hackerrank021602 {
    public static void main(String[] args){

    }
    public static long stockmax(List<Integer> prices) {
        // Write your code here
        // 뒤로가면서 맥스가 나오면 새로 판매를 정의한다.
        // 뒤부터 max 설정. result 는 result + = (max- price);
        // max가 새롭게 생기면 기존 판매는 중단, 새롭게 max를 짠다.
        int max = prices.get(prices.size()-1);
        for(int i = prices.size()-1 ; i>=0 ; i--){
            if(max < prices.get(i))
            System.out.println(prices.get(i));
        }
        return 0L;
    }
}
