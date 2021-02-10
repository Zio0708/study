import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class programmers021003 {
    static List<int[][]> keys = new ArrayList<>();
    static int[][] map;
    public static void main(String[] args){
        	int[][] key = {{0, 0, 0},
                           {1, 0, 0},
                           {0, 1, 1}};
        	int[][] lock ={{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        solution(key, lock);
    }
    public static boolean solution(int[][] key, int[][] lock) {
        //3배짜리 빅사이즈 맵을 만든다.
        map= new int[lock.length*3][lock.length*3];
        keys.add(key);
        //key를 4방향으로 돌려서 제작한다.
        makeFourKey(key);
        makeMap(lock);
        //lock의 왼쪽 상단부터 방향 제작한 키를 넣는다.
        for(int[][] keyz : keys) {
            for (int i = 1; i < 2 * lock.length; i++) {
                for (int j = 1; j < 2 * lock.length; j++) {
                    if (checkMap(i, j, keyz)) {
                        System.out.println("성공했다 씨팔");
                        break;
                    }
                }
            }
        }
        System.out.println("실패");
        //언제까지? -> 오른쪽 하단까지
        //하나라도 겹치면 아웃
        //모든 부분이 일치하면 true;
        //문제1. 4방향으로 도는 key맵 만들기
        //문제2. lock에서 모든 부분이 채워지는지 확인하기
        //
        boolean answer = true;

        return answer;
    }

    private static boolean checkMap(int i, int j, int[][] key) {
        int[][] checkMap = new int[map.length][map.length];
        for(int y=0;y<map.length;y++){
            for(int x= 0 ;x<map.length;x++) {
                checkMap[y][x]= map[y][x];
            }
        }
        for(int y = 0; y < key.length;y++){
            for(int x= 0 ;x<key.length;x++){
                checkMap[i+y][j+x]+=key[y][x];
            }
        }
        int lockLen = map.length/3;
        for(int y = lockLen; y < 2*lockLen;y++){
            for(int x= lockLen ;x<2*lockLen;x++){
                if(checkMap[y][x] != 1){
                    return false;
                }
                //System.out.print(checkMap[y][x]);
            }
            //System.out.println();
        }
        return true;
    }

    private static void makeMap(int[][] lock) {
        for(int y= 0 ; y<map.length;y++){
            for(int x= 0;  x< map.length;x++){
                map[y][x]=0;
            }
        }
        int len = lock.length;
        for(int y= 0 ; y<len;y++){
            for(int x= 0;  x< len;x++){
                map[y+len][x+len]= lock[y][x];
            }
        }
    }

    private static void makeFourKey(int[][] key) {
        for(int i = 0 ; i < 3; i++){
        int[][] rotate =new int[key.length][key.length];
        for(int y=0;y<key.length;y++){
            for(int x = 0 ; x< key.length;x++){
                rotate[x][key.length-1-y]= key[y][x];
            }
        }
        keys.add(rotate);
        key= rotate;
        //result[x][길이 -1-y] = key[y][x];
        }
    }
}
