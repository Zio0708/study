public class programmers022606 {
    public int solution(int[] a) {
        int len = a.length;
        if(len <= 2){
            return len;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = a[0];
        right[len-1] = a[len-1];
        for(int i = 1 ; i < len ; i++){
            left[i] = Math.min(left[i - 1], a[i]);
        }
        for(int j = len-2 ; j >= 0 ; j--){
            right[j] = Math.min(right[j + 1], a[j]);
        }
        int answer = 2;
        for(int i = 1; i<len-1;i++){
            if( a[i] < left[i-1] || a[i] < right[i+1]){
                answer+=1;
            }
        }
        return answer;
    }
}
