public class hackerrank021201 {
    public static void main(String[] args){
        String s = "feedthedog";
        encryption(s);
    }
    static String encryption(String s) {
        String answer="";
        s= s.replaceAll(" ","");
        int row=0;
        int col=0;
        String[][] ans;
        row= (int)Math.floor(Math.sqrt(s.length()));
        col= (int)Math.ceil(Math.sqrt(s.length()));
        int cnt=0;
        for(int i = 0 ; i < col ; i++){
            System.out.println(s.substring(cnt,cnt+row));
            cnt+=row;
        }
        //System.out.println(row+" "+col);
        return answer;
    }
}
