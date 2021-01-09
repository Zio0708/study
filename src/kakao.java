public class kakao {
    static String result ="";
    public static void main(String[] args){
        String p = "()))((()";
        String b = ")()()()(";
        solution(b);
    }
    public static String solution(String p){
        //p를 u,v로 분리
        //u는 유일 균형 잡힌 괄호
        //v에 대해 재시행
        String result;
        result = DFS(p);
        System.out.println(result);
        return result;
    }
    private static String DFS(String p) {
        //u를 균형잡힌 괄호로 만들고 나머지를 dfs(v)로 보낸다
        System.out.println("");
        if(p.length()==0){
            return "";
        }
        int check = 0;
        boolean perfect = true;
        for(int i = 0 ;i<p.length();i++){
            if(String.valueOf(p.subSequence(i,i+1)).equals(")")){
                check -=1;
                //System.out.println("?"+check);
            }
            else if(String.valueOf(p.subSequence(i,i+1)).equals("(")){
                check +=1;
            }
            if(check < 0){
                perfect = false;
            }

            if(check ==0){
                System.out.println("u : "+String.valueOf(p.subSequence(0,i+1)) + " "+ perfect);
                System.out.println("v : "+String.valueOf(p.subSequence(i+1,p.length())));
                String u = String.valueOf(p.subSequence(0,i+1));
                String v = String.valueOf(p.subSequence(i+1,p.length()));
                if(!perfect){
                   u = fixU(u);
                   return "("+DFS(v)+")"+u;
                }
                else {
                    return u + DFS(v) ;
                }
            }

        }
        return "";
    }

    private static String fixU(String u) {
        u = String.valueOf(u.subSequence(1,u.length()-1));
        String fixu="";
        for(int i = 0 ; i< u.length();i++){
            if(String.valueOf(u.subSequence(i,i+1)).equals(")")){
                fixu += "(";
            }
            else if(String.valueOf(u.subSequence(i,i+1)).equals("(")){
                fixu += ")";
            }
        }
        return fixu;
    }
}
