import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class study032101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        String[][] timeLine= new String[n][2];
        for(int i = 0; i< n ; i++){
            String[] time = br.readLine().split(" ~ ");
            timeLine[i][0]= time[0];
            timeLine[i][1]= time[1];
            //System.out.println(timeLine[i][0]);
        }

        solution(n,timeLine);

    }

    private static void solution(int n, String[][] timeLine) {
        float start=0;
        float end=24*60;
        float min;
        String startSt="-1";
        String endSt="";
        for(int i = 0;i<n;i++){
            min = Float.parseFloat(timeLine[i][0].replace(":","."));
            if(start<min){
                start=min;
                startSt=timeLine[i][0];
            }
            min = Float.parseFloat(timeLine[i][1].replace(":","."));
            if(end>min){
                end=min;
                endSt =timeLine[i][1];
            }
        }
        if(start<end) {
            System.out.println(startSt + " ~ " + endSt);
        }
        else{
            System.out.println("-1");
        }
    }

}
