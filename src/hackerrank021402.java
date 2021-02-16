import java.util.List;

public class hackerrank021402 {
    public static void main(String[] args){

    }
    static void countSort(List<List<String>> arr) {
        //절반을 -으로 바꿈
        //전체를 소팅함
        //찍어줌
        for(int i =0; i< arr.size()/2;i++){
            arr.get(i).set(1,"-");
        }


    }
}
