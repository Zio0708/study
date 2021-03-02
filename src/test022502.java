public class test022502 {







    public static String transform(String input) {
        char cnt =input.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(cnt);
        for(int i = 1 ; i <  input.length();i++){
            if(cnt != input.charAt(i)){
                sb.append(input.charAt(i));
                cnt = input.charAt(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(transform("abbcbbb"));
    }
//    public static String transform(String input) {
//        throw new UnsupportedOperationException("Waiting to be implemented.");
//    }
//public String mergeAlternately(String word1, String word2) {
//    StringBuilder sb = new StringBuilder();
//    int lenmax = Math.max(word1.length(),word2.length());
//    for(int i=0;i<=lenmax-1;i++)
//    {
//        if(i<word1.length()) sb.append(word1.charAt(i));
//        if(i<word2.length()) sb.append(word2.charAt(i));
//    }
//    return sb.toString();
//}
}
