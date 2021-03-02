import java.util.List;

public class programmers09 {
    public static void main(String[] args)
    {
        int[] numbers= 	{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand ="right";
        solution(numbers,  hand);
    }
    public static String solution(int[] numbers,String hand) {
        String answer = "";
        int[][] keypad = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
        int[] left={3,0};
        int[] right={3,2};
        if(hand.equals("right")){
            hand = "R";
        }
        else{
            hand="L";
        }
        for(int number:numbers){
            int leftmid=0;
            int rightmid=0;
            if(number == 1 || number == 4 || number == 7 ){
                answer+="L";
                left = keypad[number];
            }
            else if(number == 3 || number == 6 || number == 9 ){
                answer+="R";
                right = keypad[number];
            }
            else{
                System.out.println(number + " "+keypad[number][0] + " "+keypad[number][1]);
                leftmid  = Math.abs(left[0]-keypad[number][0]) +Math.abs(left[1]-keypad[number][1]);
                rightmid  = Math.abs(right[0]-keypad[number][0]) +Math.abs(right[1]-keypad[number][1]);
                //System.out.println("손길이"+leftmid+" "+rightmid);
                if(leftmid == rightmid){
                    answer+=hand;
                    if(hand.equals("L")){
                        left = keypad[number];
                    }
                    else{
                        right = keypad[number];
                    }
                }
                else if(leftmid<rightmid){
                    answer+="L";
                    left = keypad[number];
                }
                else{
                    answer+="R";
                    right = keypad[number];
                }

            }

        }
        System.out.println(answer);
        //왼쪽은 147은 L
        //오른쪽 369는 R
        //2580 은 가까운 손가락
        //손가락 계산은 열 절대값 + 행 절대값 으로 L R 둘다구함
        //만약 똑같으면 -> hand 에 의해서 결정.
        return answer;
    }
}
