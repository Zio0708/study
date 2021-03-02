public class hackerrank021501 {
    public static void main(String[] args){

    }
    static int hourglassSum(int[][] arr) {
        int max = arr[0][0]+ arr[0][1]+ arr[0][2]
                + arr[1][1]+ arr[2][0]+ arr[2][1]
                + arr[2][2];
        for(int y= 0 ; y< arr.length-2;y++){
            for(int x= 0 ; x<arr[0].length-2;x++){
                max = Math.max(max , arr[y][x]+arr[y][x+1]+arr[y][x+2]
                        +arr[y+1][x+1]+arr[y+2][x]+arr[y+2][x+1]
                        +arr[y+2][x+2]);
            }
        }
        return max;
    }

}