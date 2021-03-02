import java.math.BigInteger;

public class hackerrank021301 {
    public static void main(String[] args){
        extraLongFactorials(30);
    }
    static void extraLongFactorials(int n) {
        BigInteger answer=new BigInteger("1");

        while(n >=1){
            answer= answer.multiply(BigInteger.valueOf(n));

            n--;
        }

    }

}
