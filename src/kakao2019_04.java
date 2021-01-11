public class kakao2019_04 {
    static int[][] boardCheck;
    static int[][] rowCheck ={{}};
    public static void main(String[] args){
        //5가지 블록말고는 전부 안됨
        //되는 블록위에 안되는 블록이 있으면 되는 블록도 안된다.
        //안되는 블록을 체크하여 그 줄을 모두 안된다고 체크한다.
        //영향 받지 않는 블록의 갯수를 센다.

        //재코딩

        //5가지 블록만 된다. --> 가로가 긴 3경우 , 세로가 긴 2경우 를 저장한다.
        //완전탐색으로 한 칸씩 내려가면서 가로가능, 세로가능을 탐색한다.
        //가능한 경우 위에 도형이 있는지 검사한다.
        //위에 도형이 없으면 그 도형자체를 보드에서 지운다.
        //보드에서 지우고 총 갯수에 1을 더한다.
        int[][] board= {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 4, 0, 0, 0},
                {0, 0, 0, 0, 0, 4, 4, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 4, 0, 0, 0},
                {0, 0, 0, 2, 3, 0, 0, 0, 5, 5},
                {1, 2, 2, 2, 3, 3, 0, 0, 0, 5},
                {1, 1, 1, 0, 0, 0, 0, 0, 0, 5}};
        solution(board);
    }
    public static void solution(int[][] board){
        boardCheck = board;
        int answer = 0;
        for(int i = 0 ; i < board.length;i++){
            for(int j =0; j<board[0].length;j++){
                System.out.println(i+" "+j);
                if(checkRow(i,j) && checkUpRow(i,j)){
                    eraseBoardRow(i,j);
                    answer+=1;
                    System.out.println("지워");
                }
                else if(checkCol(i,j) && checkUpCol(i,j)){
                    eraseBoardCol(i,j);
                    answer+=1;
                    System.out.println("옆으로 지워");
                }
            }
        }
    }

    private static void eraseBoardRow(int i, int j) {
        for(int row = i ;row<=i+2;row++){
            for(int col =j; col<=j+1;j++){
                boardCheck[row][col]=0;
            }
        }
    }
    private static void eraseBoardCol(int i, int j) {
        for(int row = i ;row<=i+1;row++){
            for(int col =j; col<=j+2;j++){
                boardCheck[row][col]=0;
            }
        }
    }
    private static boolean checkUpRow(int i, int j) {
        for(int row = i ;row<i+2;row++){
            for(int col =0; col<j;j++){
                if(boardCheck[row][col] != 0){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean checkUpCol(int i, int j) {
        for(int row = i ;row<i+1;row++){
            for(int col =0; col<j;j++){
                if(boardCheck[row][col] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkRow(int i, int j) {
        if(i+2 >= boardCheck.length || j+1 >= boardCheck[0].length){
            return false;
        }

        return true;
    }
    private static boolean checkCol(int i, int j) {
        if(i+1 >= boardCheck.length || j+2 >= boardCheck[0].length){
            return false;
        }
        return true;
    }
}
