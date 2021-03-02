import java.util.*;

public class test022501 {
    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {

        Collection<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer > hash = new HashMap<>();
        for(int num : numbers){
            if(hash.containsKey(num)){
                hash.put(num , hash.get(num)+1);
            }
            else{
                hash.put(num,1);
            }
        }
        Iterator<Integer> keys = hash.keySet().iterator();
        while( keys.hasNext() ){
            Integer key = keys.next();
            if(hash.get(key) ==1){// value 체크
                answer.add(key);
            }
        }


        return answer;
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }
//    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
//        throw new UnsupportedOperationException("Waiting to be implemented.");
//    }
}
