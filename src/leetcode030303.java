public class leetcode030303 {
    static boolean[][] check;
    static int answer=0;
    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        check = new boolean[grid.length][grid[0].length];
        for(int i = 0 ; i< grid.length;i++){
            for(int j = 0 ; j < grid[0].length;j++){
                if(!check[i][j] && grid[i][j] =='1'){
                    answer+=1;
                    check[i][j]=true;
                    dfs(i,j,grid);
                }
            }
        }
        return 1;
    }

    private void dfs(int i, int j, char[][] grid) {
        //네방향을 측정하는 dfs를 짜왔는데




    }

    public int numIslands2(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
    //깔끔하게 짜는 방법은 다음과 같다.
    //적당하게 비교되는 부분은 미리 위로 올리고
    //dfs를 타고 들어가서 조건에 안맞으면 뒤로 가면 그만이다.
}
