import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class line02 {
    public static void main(String[] args){
        int[][] line =new int[2][2];
        solution(line);
    }
    public static String[] solution(int[][] line) {
        double minX= 200001;
        double minY= 200001;
        double maxX= -200001;
        double maxY= -200001;
        HashSet<String> map = new HashSet<>();
        for(int i  =0 ; i< line.length-1; i++){
            for(int j  = i ; j< line.length ; j++){
                if(((line[i][0]*line[j][1])-(line[i][1]*line[j][0])) !=0) {
                    double crossX = (double)((line[i][1] * line[j][2]) - (line[i][2] * line[j][1])) /
                            (double)((line[i][0] * line[j][1]) - (line[i][1] * line[j][0]));
                    double crossY = (double)((line[i][2] * line[j][0]) - (line[i][0] * line[j][2])) /
                            (double)((line[i][0] * line[j][1]) - (line[i][1] * line[j][0]));
                    if(crossX == -0.0){
                        crossX = 0;
                    }
                    if(crossY == -0.0){
                        crossX = 0;
                    }
                    if(crossX %1 ==0 && crossY %1==0){
                        map.add(crossX+" "+crossY);
                    }
                    minX = Math.min(minX, crossX);
                    minY = Math.min(minY, crossY);
                    maxX = Math.max(maxX, crossX);
                    maxY = Math.max(maxX, crossY);
                }
            }
        }
        int len =(int)(maxY-minY+1);
        if(maxY-minY ==0){
            len = 1;
        }
        String[] answer = new String[len];
        int ansLen=0;
        for(double i = maxY;i>=minY;i--){
            String cnt ="";
            answer[ansLen]=cnt;
            for(double j=minX;j<=maxX;j++){
                if(map.contains(j+" "+i)){
                    cnt+="*";
                }
                else{
                    cnt+=".";
                }
            }
            //System.out.println(cnt);
            answer[ansLen]+=cnt;
            ansLen+=1;
        }
        return answer;
    }
}
