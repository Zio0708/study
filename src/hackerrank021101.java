public class hackerrank021101 {
    //Forming a Magic Square문제
    static int[][][] magic_mat=new int[][][]{
        {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
        {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
        {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
        {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
        {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
        {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
        {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
        {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
    };
    public static void main(String[] args){
        int[][] s = {{4, 8, 2,},
                {4, 5, 7},
                {6, 1, 6}};
        formingMagicSquare(s);
    }
    static int formingMagicSquare(int[][] s) {
        int min= 10000;
        for(int [][] compare : magic_mat){
            min= Math.min(min, checkMin(compare, s));
        }
        System.out.println(min);
        return min;
    }

    private static int checkMin(int[][] compare, int[][] s) {
        int answer=0;
        for(int y = 0 ; y < s.length; y++){
            for(int x = 0 ; x< s.length; x++){
                answer += Math.abs(compare[y][x] - s[y][x]);
            }
        }
        return answer;
    }

}
