import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class programmers020802 {
    public static void main(String[] args){
        String[] gem={"XYZ", "XYZ", "XYZ"};//{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        solution( gem);
    }
    public static int[] solution(String[] gems) {
        int[] answer =new int[2];
        //가장 짧게 보석이 포함된 구간을 구하시오

        //구간을 구하자.
        List<String> realGem=findGem(gems);//보석을 찾자
        HashMap<String,Integer> gemHash = new HashMap<>();
        for(int i=0;i< realGem.size();i++ ){
            gemHash.put(realGem.get(i),0);
        }//보석이 포함되는 것을 아는 배열을 만들자


        int left=0;
        int right=0;//보석이 포함된 구간을 구하자

        int minLen=100001;

        //보석 완성은 : 어떻게 gem[i]가 해당 보석이면 갯수 +1
        //모든 보석에 0이 없으면 완성.
        while(right >= left){//언제까지: 마지막 라인이 size를 넘어갈때.
            int gemNum = gemHash.get(gems[right]);
            gemHash.put(gems[right],gemNum+1);
            if(gemHash.containsValue(0)){//어떻게 :  완성안되면 right+1
                right+=1;
            }
            else{//보석이 완성되면 : left+1
                if(minLen > right-left){
                    minLen = right-left;//구간 최소일시 보석이 포함되는 길이 저장
                    //보석의 구간 저장.
                    answer[0]=left;
                    answer[1]=right;
                }
                gemHash.put(gems[left],gemHash.get(gems[left])-1);
                left+=1;
                //left+1하면서 이전의 보석을 뺀다.
            }
        }
        return answer;
    }

    private static List<String> findGem(String[] gems) {
        List<String> realGem= new ArrayList<>();
        for(String gem: gems){
            if(!realGem.contains(gem)) {
                realGem.add(gem);
            }
        }
        return realGem;
    }

}
