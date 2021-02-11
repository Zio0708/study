public class hackerrank021104 {
    static boolean[][] check;
    static int max;
    public static void main(String[] args){

    }
    static int connectedCell(int[][] matrix) {
        check = new boolean[matrix.length][matrix.length];
        int answer= 0;

        for(int y = 0 ; y < matrix.length; y++){
            for(int x = 0  ; x< matrix[0].length; x++){
                if(!check[y][x] && matrix[y][x] ==1){
                    max=0;
                    check[y][x]=true;
                    dfs(x,y,matrix);
                    answer+=1;

                }
            }
        }
        return answer;
    }

    private static void dfs(int x, int y, int[][] matrix) {
        max+=1;
        System.out.println(y+" "+x+max);
        if(!check[y][x] && checkOut(x+1,y)&& matrix[y][x+1] ==1){
            check[y][x+1]=true;
            dfs(x+1,y,matrix);
        }
        if(!check[y][x] && checkOut(x,y+1)&& matrix[y+1][x] ==1){
            check[y+1][x]=true;
            dfs(x,y+1,matrix);
        }
        if(!check[y][x] && checkOut(x-1,y)&& matrix[y][x-1] ==1){
            check[y][x-1]=true;
            dfs(x-1,y,matrix);
        }
        if(!check[y][x] && checkOut(x,y-1)&& matrix[y-1][x] ==1){
            check[y-1][x]=true;
            dfs(x,y-1,matrix);
        }
    }

    private static boolean checkOut(int x, int y) {
        if(x>= check.length || x<0  ||y>= check[0].length || y<0){
            return false;
        }
        return true;
    }
}
