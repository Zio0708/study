public class hackerrank021502 {
    //The Maximum Subarray
    public static void main(String[] args){
        int[] arr = {2 ,-1 ,2 ,3, 4 ,-5};
        maxSubarray(arr);
    }
    static void maxSubarray(int[] arr) {
        int maxAry=-1;
        int maxSub=0;
        int sum = 0;
        for(int i = 0 ; i <arr.length;i++){
            sum += arr[i];
            maxAry=Math.max(maxAry,sum);
            if(sum <= 0){
                sum =0;
            }
            if(arr[i] > 0 ){
                maxSub+= arr[i];
            }
        }
        int[] answer = {maxAry,maxSub};
        System.out.println(maxAry + " "+maxSub);
    }
}