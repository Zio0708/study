package template;

import java.io.*;
import java.util.StringTokenizer;

public class backjoon {//Main클래스 변환
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());//n 받기
        int[] left= new int[n];//배열인 경우 실행
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            left[i] = Integer.parseInt(st.nextToken());//한줄배열인 경우
            //left[i] = Integer.parseInt(br.readLine());//여러줄 배열인 경우
        }

//        bw.write(solution(n,left) + "\n");
//        bw.close();
//        br.close();
    }
    private static void solution(int n, int[] left) {
    }
}

