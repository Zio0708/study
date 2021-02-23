public class leetcode022302 {
    public static void main(String[] args){

    }
    public int maxArea(int[] height) {
        int left =0;
        int right= height.length-1;
        int max=0;
        while(left<= right){
            int lLen = height[left];
            int rLen = height[right];
            int width = right-left;
            if(lLen <= rLen){
                left++;
            }
            else{
                right--;
            }
            max= Math.max(max , width * Math.min(lLen,rLen));

        }
        return max;
    }
}
