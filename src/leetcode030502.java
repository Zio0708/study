import java.util.*;

public class leetcode030502 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0)return new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String st: strs){
            char[] ch = st.toCharArray();
            Arrays.sort(ch);
            String keyStr = String.valueOf(ch);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(st);
        }
        return new ArrayList<>(map.values());
    }//hashmap을 쓰는 건 동일하지만 str의 전처리를 통해서 다듬어 분류를 쉽게 만듬.
    //현실적으로 지금 시험에서는 더 나은 최적화 방법을 알아차리지 못할듯
}
