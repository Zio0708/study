public class study031202 {
    public static void main(String[] args){
        String word= "aAAa abad d";
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < word.length();i++){
            char cnt= word.charAt(i);
            if(Character.isUpperCase(cnt)){
                cnt = (char) ('Z'-cnt+'A');
                sb.append(cnt);
            }
            else if(Character.isLowerCase(cnt)){
                cnt = (char) ('z'-cnt+'a');
                sb.append(cnt);
            }
            else{
                sb.append(cnt);
            }
        }
        System.out.println(sb);
    }
}
