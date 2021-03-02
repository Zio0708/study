public class hackerrank021601 {
    public static void main(String[] args){

        //bomberMan(1,);
    }
    static String[] bomberMan(int n, String[] grid) {
        //1초에는 아무것도 안함
        String[] save = new String[grid.length];
        String[] answer= new String[grid.length];
        if(n == 1){
            return grid;
        }
        save = grid;
        answer=grid;
        for(int i = 2 ;i<=n ; i++ ){
            if(n%2 ==0){//짝수시간
                answer = makeZero(grid);
            }
            else{//홀수시간에는 n-2되어있던 맵을 폭발시킴
                answer = makeBoom(save);
                save = answer;
            }
        }

        //2초에는 맵을 폭탄으로 가득채움
        //3초에는 처음 설치한 폭탄이 터짐
        //2초와 3초를 반복(4초에는 폭탄가득, 5초에는 3초에 존재한 폭탄터짐)

        //2,4,6,8초에는 맵에 폭탄이 가득차있다
        //3초, 5 ,7초는 n-2초의 폭탄이 터진다.



        return grid;
    }

    private static String[] makeBoom(String[] save) {
        for(int i = 0;  i <save.length;i++){
            for(int j = 0 ; j<save[0].length();j++){
                if(save[i].substring(j,j+1) =="0"){
                    //save[i].rep





                }
            }
            //answer[i]=line;
        }
        return save;
    }

    private static String[] makeZero(String[] grid) {
        String[] answer= new String[grid.length];
        for(int i = 0;  i <grid.length;i++){
            String line ="";
            for(int j = 0 ; j<grid[0].length();j++){
                line+="O";
            }
            answer[i]=line;
        }

        return answer;
    }
}
