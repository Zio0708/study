import java.util.Locale;

public class programmers020901 {
    public static void main(String[] args){
        String new_id = "abcdefghijklmn.p";//"123_.def";//"z";//"z-+.^.";//"...!@BaT#*..y.abcdefghijklm";
        //	"z-+.^.";
        //	"123_.def";
        solution(new_id);
    }
    public static String solution(String new_id) {
        String answer = "";
        new_id =  step1(new_id);//        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        System.out.println("답1:"+new_id);
        new_id =  step2(new_id);//        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        System.out.println("답2:"+new_id);
        new_id =  step3(new_id);//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        System.out.println("답3:"+new_id);
        new_id =  step4(new_id);//        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        System.out.println("답4:"+new_id);
        new_id =  step5(new_id);//        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        System.out.println("답5:"+new_id);
        new_id =  step6(new_id);//        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //                만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        new_id =  step7(new_id);//        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        System.out.println("답:"+new_id);


        return answer;
    }

    private static String step7(String new_id) {
        if(new_id.length()<=2){
            String last = new_id.substring(new_id.length()-1,new_id.length());
            while(new_id.length()<=2){
                new_id += last;
            }
        }
        return new_id;
    }

    private static String step6(String new_id) {
        if(new_id.length()>=16){
            new_id = new_id.substring(0,15);
            new_id = new_id.replaceAll("\\.$","");
        }
        return new_id;
    }

    private static String step5(String new_id) {
        if(new_id.length()==0){
            return "a";
        }
        return new_id;
    }

    private static String step4(String new_id) {
        return  new_id.replaceAll("^\\.|\\.$","");
    }
    private static String step3(String new_id) {
        return new_id.replaceAll("[\\.]{2,}",".");
    }
    private static String step2(String new_id) {
        return new_id.replaceAll("[^0-9a-z-_.]","");//
    }

    public static String step1(String new_id) {
        return new_id.toLowerCase(Locale.ROOT);
    }
}
