import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class programmers020902 {
    static int[] cal = new int[366];//1.달력을 일렬로 만든다.
    static int[] month=  {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args){
        String[] holidays= {"01/14","01/15","01/18","01/22","01/23","01/29","02/01","02/03","02/07"};
        int k = 3;
        solution(holidays,k);
    }
    public static int solution(String[] holidays, int k ){
        int answer= -1;

        //k번째로 긴 연속 휴일 기간은?
        //기간만 구하면 되니까 그냥 리스트에 중복없이 넣고 소팅한다.
        //2.달력에서 주말을 뽑는다. 나머지 =토2,일3 월4 화5 수6 목0 금1주말.
        checkHolidays(holidays);//공휴일에 1을 넣는다.
        checkFriSun();//주말에 1을 넣는다.
        List<Integer> holidayLen =new ArrayList<>();
        int cnt = 0;

        for(int i = 0 ; i <39;i++){
            if(cal[i]==1){
                cnt++;
            }
            else if(cnt !=0){//휴일이 아닐때 ->휴일의 길이가 0이고 휴일의 길이가 처음일때
                if(!holidayLen.contains(cnt)) {
                    holidayLen.add(cnt);//휴일의 길이를 넣고
                }
                System.out.println("휴일의 길이"+cnt);
                cnt=0;
            }
            System.out.print(cal[i]+" ");
        }//for문을 돌면서 가장 긴 휴일을 체크한다.

        Collections.sort(holidayLen);
        System.out.println("답"+holidayLen.get(holidayLen.size()-k));
        return answer;
    }

    private static void checkFriSun() {//주말 계산해서 넣어줌
        for(int i = 0 ; i < 366;i++){
            if(i % 7 ==2 || i%7 ==3){
                cal[i] = 1;
            }
        }
    }
    private static void checkHolidays(String[] holidays) {//휴일 계산해서 넣어줌
        //2.1 달력의 월일을 일수로 계산한다. =  달. 이전의 달을 더하고 +날짜을 한다.
        for(String holiday: holidays){
            int mon = Integer.parseInt(holiday.split("/")[0]);
            int day = Integer.parseInt(holiday.split("/")[1]);
            int result=0;
            for(int i=0;i<mon;i++){
                result += month[i];
            }
            System.out.println(mon+" "+day+" "+(result+day));
            cal[result+day]=1;
        }//공휴일 1계산
    }
}
