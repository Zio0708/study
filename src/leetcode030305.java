public class leetcode030305 {
    public int singleNumber(int[] nums) {
        int ans =0;

        int len = nums.length;
        for(int i=0;i!=len;i++)
            ans ^= nums[i];

        return ans;

    } //비트 연산자를 활용해보자

}
