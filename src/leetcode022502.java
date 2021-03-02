public class leetcode022502 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // Calculate lefts and store in res.
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                left = left * nums[i - 1];
            res[i] = left;
        }
        // Calculate rights and the product from the end of the array.
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1)
                right = right * nums[i + 1];
            res[i] *= right;
        }
        return res;
    }
    //푼다기 보다는 아이디어를 기억하는 용도로 저장한다.
    //왼쪽과 오른쪽을 각각 곱하면 해당 숫자만 제외한 숫자를 만들 수 있다.
}
