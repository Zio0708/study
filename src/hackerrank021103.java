import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hackerrank021103 {
    public static void main(String[] args){

    }
    static String organizingContainers(int[][] container) {
        int[] contain =new int[container.length];
        int[] types = new int[container.length];
        Arrays.fill(contain,0);
        Arrays.fill(types,0);
        for(int i = 0 ; i < contain.length;i++){
            for(int j =0; i< contain.length;j++){
                contain[i]+=container[i][j];
                types[j]+=container[i][j];
            }
        }
        Arrays.sort(contain);
        Arrays.sort(types);

        for(int i = 0 ; i < contain.length;i++){
            System.out.println(contain[i] +" "+types[i]);
        }
        if(contain.equals(types)){
            return "Possible";
        }//당연히 안됨

        return "Impossible";
    }

}
