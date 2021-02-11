import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class hackerrank021102 {
    //Climbing the Leaderboard
    public static void main(String[] args){

    }
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        //랭크를 돌면서 중복을 제거한다.
        List<Integer> rank = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        for(Integer cnt : ranked){
            if(!rank.contains(cnt)){
                rank.add(cnt);
            }
        }
        Collections.sort(player);
        int checkRank=1;
        //플레이어를 돌면서 랭크를 체크한다.
        for(Integer score: player){
            if(score > rank.get(0)){//랭크 1위보다 점수높거나 같으면
                answer.add(1);//너가 일등이다.
                checkRank = 1;
            }
            else {//아니야?
                checkRank = 2;//2위부터 시작해서
                for (int i = checkRank-1; i < rank.size(); i++) {//플레이어 점수가 랭크 점수보다 크면 고정한다. 2위부터 체크
                    if (rank.get(i) >= score) {
                        System.out.print(i+1);
                        answer.add(i+1);
                        break;
                    }
                    //플레이어보다 랭크점수가 클때 순위에 +1을 하고 다음 랭크를 본다.
                }
                System.out.println(rank.size());
                answer.add(rank.size()); //꼴지면 꼴지 순위 입력
            }
        }

        return answer;
    }
    //제한조건좀 확실히알기
    //제한조건에 맞게 확실하게 구현하기
    //돌겠네 진짜
    //이미 체크했으니 그 뒤는 절약할 수 있었음


}
