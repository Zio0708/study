public class leetcode030304 {
    static int n;
    static int m;
    static String words;
    static boolean answer;
    public boolean exist(char[][] board, String word) {
        int count = 0;
        n = board.length;
        if (n == 0) return false;
        m = board[0].length;
        words= word;
        answer=false;
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (board[i][j] == word.charAt(0)) {
                    DFSMarking(board, i,j,sb.append(board[i][j]));
                    ++count;
                }
        }
        return answer;
    }

    private void DFSMarking(char[][] board, int i, int j, StringBuilder sb) {
        if(sb.toString().equals(words)) {
            answer = true;
            return;
        }
        if (i < 0 || j < 0 || i >= n || j >= m) return;
        DFSMarking(board, i + 1, j, sb.append(board[i][j]));
        DFSMarking(board, i - 1, j, sb.append(board[i][j]));
        DFSMarking(board, i, j + 1, sb.append(board[i][j]));
        DFSMarking(board, i, j - 1, sb.append(board[i][j]));
    }

    static boolean[][] visited;
    public boolean exist2(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }

        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) ||
                search(board, word, i+1, j, index+1) ||
                search(board, word, i, j-1, index+1) ||
                search(board, word, i, j+1, index+1)){
            return true;
        }

        visited[i][j] = false;
        return false;
    }
    //뒤로 돌아가는 조건을 빡빡하게 설정해 놓으면 dfs 타고 들어가는 부분은 간단하게 처리할 수 있음.
}
