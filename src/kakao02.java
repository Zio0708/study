import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class kakao02 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        solution(N, stages);
    }

    public static int[] solution(int N, int[] stages) {
        //N의 갯수만큼 실패율을 담는 배열 설계
        //N만큼 돌면서...N인 배열 을 N이상인 배열로 나눈다.
        //이를 실패율 배열에 넣는다
        //sort시킨다.
        int[] answer = new int[N];
        float[][] compareAry = new float[N][2];
        for (int i = 0; i < N; i++) {
            float nup = 0;
            float ndown = 0;
            compareAry[i][0] = i;
            for (int j = 0; j < stages.length; j++) {
                if (i == stages[j] - 1) {
                    nup += 1;
                }
                if (i <= stages[j] - 1) {
                    ndown += 1;
                }

            }
            if(ndown == 0) {
                compareAry[i][1] = -1;
            }else{
                compareAry[i][1] = nup / ndown;
            }
            System.out.println("cnt" + compareAry[i][0] + " " + compareAry[i][1]);
        }
        Arrays.sort(compareAry, new Comparator<float[]>() {
            @Override
            public int compare(float[] o1, float[] o2) {
                if (o1[1] < o2[1]) {
                    return 1;
                } else if (o1[1] == o2[1]) {
                    return 0;//(int) (o1[0] - o2[0]);
                } else {
                    return -1;
                }

            }
        });
        for (int i = 0; i < compareAry.length; i++) {
            answer[i] = (int) compareAry[i][0]+1;
            System.out.println(answer[i]);
        }
        return answer;
    }
}
