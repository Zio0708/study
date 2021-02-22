import java.util.Arrays;

public class leetcode022201 {
    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        int numRows = 3;
        convert(s,numRows);
    }
    public static String convert(String s, int numRows) {
        int len = s.length();
        String[][] ary= new String[numRows][len];
        int cnt=0;
        int phase =1;
        int y=0;
        int x=0;
        for(String[] ar : ary){
            Arrays.fill(ar," ");
        }
        while(cnt < len){
            if(phase == 1){
                for(int i= 0;i <numRows;i++){
                    if(cnt < len) {
                        //System.out.println(i+" "+x+s.substring(cnt, cnt + 1));
                        ary[i][x] = s.substring(cnt, cnt + 1);
                        cnt+=1;
                    }
                }
                phase=2;
            }
            else if(phase ==2){
                //대각선으로 상승
                for(int i = 0; i<numRows-2; i++){
                    if(cnt < len) {

                        x += 1;
                        //System.out.print(numRows - 2 - i+" "+x);
                        ary[numRows - 2 - i][x] = s.substring(cnt, cnt + 1);
                        //System.out.println(ary[numRows - 2 - i][x]);
                        cnt += 1;
                    }
                }
                x+=1;
                phase=1;
            }

        }
        String answer ="";
        for(int i  = 0; i<numRows;i++){
            for(int j = 0; j<len;j++){
                //System.out.print(ary[i][j]);
                answer+=ary[i][j];
            }
            //System.out.println();
        }
        //System.out.println();
        return answer.replaceAll(" ","");
    }

    public String convert2(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }//문제 : char를 써서 다이어트좀 하자 , Stringbuffer도 괜찮다
    //append도 적극적으로 활용해보자

}
