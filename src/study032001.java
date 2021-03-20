import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class study032001 {
    static HashMap<String, String> flagRules;
    static HashMap<String, String> flagAlias;
    public static void main(String[] args){
//        String program= "trip";
//        String[] flag_rules= {"-days NUMBERS", "-dest STRING"};
//        String[] commands= {"trip -days 15 10 -dest Seoul Paris", "trip -days 10 -dest Seoul"};//{"line -n 100 -s hi bye -e", "lien -s Bye"};
//        solution(program,flag_rules,commands);
    }
    public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = new boolean[commands.length];
        int cnt=0;
        flagRules= new HashMap<>();
        flagAlias= new HashMap<>();
        Arrays.fill(answer,true);
        for(String flag_rule : flag_rules){
            String[] flag = flag_rule.split(" ");
            if(flag[1].equals("ALIAS")){
                flagAlias.put(flag[0],flag[2]);
            }
            flagRules.put(flag[0],flag[1]);
        }//명령어를 정리한다.
        for (String Key : flagAlias.keySet())
        {

        }

        for(String command : commands){

            String[] flagArgus = command.split(" ");//띄어쓰기로 명령어를 나눈다.
            if(!flagArgus[0].equals(program)){//프로그램명이 맞는지 확인한다.
                answer[cnt]=false;
                continue;
            }
            boolean checkFlag=false;
            List<String> flags=new ArrayList<>();
            String flagRule="";
            for(int j = 1 ; j< flagArgus.length;j++){
                if(flagArgus[j].contains("-") && !checkFlag){ //첫번째 flag 명령어만 입력받는다.
                    checkFlag=true;
                    flagRule=flagArgus[j];
                }
                else if(!flagArgus[j].contains("-")&& checkFlag){//flag 명령어가 아닌 단어들을 리스트에 저장한다.
                    flags.add(flagArgus[j]);
                }
                else if(flagArgus[j].contains("-") && checkFlag){//flag 명령어가 다시 들어오게 되면 저장된 단어의 유효성 검사를 실시한다.
                    answer[cnt]=checkFlags(flagRule,flags);
                    flagRule=flagArgus[j];//새롭게 flag 명령어를 설정하여 준다.
                    flags=new ArrayList<>();//flag 명령어 이후의 단어 리스트를 재설정한다.
                }
                else{//flag 명령어 없이 단어가 나오는 경우를 체크한다.
                    answer[cnt]=false;
                    continue;
                }
            }
            if(answer[cnt]) {//마지막 명령어와 단어 리스트의 유효성 검사를 실시한다.
                answer[cnt]=checkFlags(flagRule, flags);
            }
            cnt++;//유효성 체크 리스트 인덱스를 증가시킨다.
        }
        return answer;
    }

    private static boolean checkFlags(String flagRule, List<String> flags) {
        String rule = flagRules.get(flagRule);
        String pattern="";
        if(rule.equals("NULL")){//NULL인 경우에는 단어의 리스트가 없어야 한다.
            if(flags.size()!=0){
                return false;
            }
        }
        if(rule.equals("NUMBER")||rule.equals("NUMBERS")){//숫자인지 확인하는 정규식.
            pattern = "^[0-9]*$";
        }
        else if(rule.equals("STRING")||rule.equals("STRINGS")){//글자인지 확인하는 정규식.
            pattern = "^[a-zA-Z]*$";
        }
        if(rule.equals("NUMBER")||rule.equals("STRING")){
            if(flags.size()!=1){
                return false;
            }
        }
        for(String flag: flags){//단어 리스트를 돌면서 정규식을 실행한다.
            if(!Pattern.matches(pattern, flag)){
                return false;
            }
        }//모든 정규식을 통과하는 경우에만 true를 반환한다.
        return true;
    }
}
