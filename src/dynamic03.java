import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class dynamic03 {
    static int[] C = new int[1000];
    static int[] B = new int[1000];
    static int move =1;
    public static void main(String[] args){
        Arrays.fill(C,0);
        Arrays.fill(B,0);

        sticker(11,2);

    }

    private static int sticker(int c, int b) {
        for(int i = move ; i<10;i++) {
            c = c+i;
            for(int j = 0 ; j < c+2; j++){
                if(B[j] !=0 && b>=0){
                    B[b - 1] = i;
                    B[b + 1] = i;
                    B[b * 2] = i;
                }
            }
            System.out.println(c);
//            C[c + move] = move;
//            B[b - 1] = move;
//            B[b + 1] = move;
//            B[b * 2] = move;
        }
        return 1;
    }

}
