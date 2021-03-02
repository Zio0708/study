import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode022304 {
    //3sum
    static boolean[] visit;
    static List<List<Integer>> answer;
    public List<List<Integer>> threeSum(int[] nums) {
        //3000개 밖에 안되는 것을 보아 백트래킹 문제
        //각각의 진행 상황의 조합을 모두 보면서 해당 결과값이 맞으면 집어넣으면 된다.
        answer= new ArrayList<>();
        visit = new boolean[nums.length];
        Arrays.sort(nums);
        for(int i = 0 ; i< nums.length-2;i++){
            if(!visit[i]){
                visit[i]=true;
                ArrayList<Integer> ary= new ArrayList<>();
                ary.add(nums[i]);
                dfs(nums,i,nums[i],ary);
                visit[i]=false;
                ary.remove(ary.size()-1);
            }
        }


        return answer;
    }

    private void dfs(int[] nums, int cnt,int sum, ArrayList<Integer> ary) {
        if(ary.size() == 3){
            if(sum == 0 && !answer.contains(ary)){
                answer.add(new ArrayList<>(ary));
            }
            return;
        }
        for(int i = cnt ; i< nums.length;i++){
            if(!visit[i]){
                visit[i]=true;
                ary.add(nums[i]);
                dfs(nums,i,sum+nums[i],ary);
                visit[i]=false;
                ary.remove(ary.size()-1);
            }
        }
    }
    public List<List<Integer>> threeSum2(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                //이분탐색
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}
