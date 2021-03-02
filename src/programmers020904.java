import java.lang.reflect.Array;
import java.util.*;

public class programmers020904 {
    static HashMap<String,Integer> combiList = new HashMap<>();
    static boolean[] visited;
    public static void main(String[] args){
        String[] orders = {"XYZ", "XWY", "WXA"};//{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        solution(orders,course);
    }
    public static String[] solution(String[] orders, int[] course) {
        List<String>answer = new ArrayList<>();
        for(String order: orders){
            String[] orderz = new String[order.length()];
            for(int i = 0; i < order.length(); i++){
                orderz[i] = order.substring(i,i+1);
            }
            Arrays.sort(orderz);
            visited = new boolean[orderz.length];

            for(int i = 2; i <= orderz.length;i++) {
                combi(orderz, 0, i);
            }
            System.out.println();
        }

        List<String> result =new ArrayList<>();
        for(int courz :course){//단품 갯수
            int max = 2;
            for( String key : combiList.keySet() ){//조합을 보며
                //System.out.println( String.format("키 : %s, 값 : %s", key, combiList.get(key)) );
                if(key.length() ==courz && combiList.get(key)>=2){//단품 갯수가 같은 것중에 주문양 최고를 가린다.
                    max = Math.max(max,combiList.get(key));
                }
            }
            System.out.println(courz+"의 최고 값은"+max);
            for( String key : combiList.keySet() ){//조합을 보며
                //System.out.println( String.format("키 : %s, 값 : %s", key, combiList.get(key)) );
                if(key.length() ==courz && combiList.get(key)==max){//단품 갯수가 같은 것중에 주문양 최고를 가린다.
                    result.add(key);
                }
            }
        }
        String[] ans = new String[result.size()];

        int cnt=0;
        for(String res : result){
            ans[cnt]= res;
            cnt++;
        }
        Arrays.sort(ans);
        for(String a : ans){
            System.out.print(a+" ");
        }
        return ans;
    }

    private static void combi(String[] orderz,int start, int r) {
        if(r ==0){
            String cnt="";
            for(int i = 0 ; i < visited.length;i++){
                if(visited[i]){
                    cnt+=orderz[i];
                }
            }
            System.out.print(cnt+ " ");
            if(combiList.containsKey(cnt)){
                combiList.put(cnt,combiList.get(cnt)+1);
            }
            else{
                combiList.put(cnt,1);
            }
            return;
        }
        for(int i = start ; i<orderz.length;i++){
            visited[i]=true;
            combi(orderz,i+1,r-1);
            visited[i]=false;
        }
    }
}
