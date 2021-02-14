public class hackerrank021401 {
    public static void main(String[] args){
        //gridSearch(g,p);

    }
    public static String gridSearch(String[] g, String[] p) {
        char first= p[0].charAt(0);
        for(int j = 0 ; j < g.length; j++){
            for(int i= 0 ; i< g[0].length();i++){
                if(checkOut(j,i,p.length,p[0].length(),g) && g[j].charAt(i) == first){
                    if(checkP(j,i,g,p)){
                        return "YES";
                    }
                }

            }
        }
        return "NO";
        //g를 돌면서 p의 첫글자를 체크한다.

        //일치하면 전체 체크 메소드를 돌린다.
        //하나라도 틀리면 아웃
        //모두 통과하면 인



    }

    private static boolean checkOut(int j, int i, int yLen, int xLen, String[] g) {
        if(j+yLen >=g.length || i+xLen >= g[0].length()){
            return false;
        }
        return true;

    }

    private static boolean checkP(int j, int i, String[] g, String[] p) {
        for(int y=j ; y<j+p.length;y++){
            for(int x=i ; x< i+p[0].length();x++){
                System.out.print(g[y].charAt(x));
                if(g[y].charAt(x) != p[y-j].charAt(x-i)){
                    return false;
                }
            }
        }

    return true;
    }
}
