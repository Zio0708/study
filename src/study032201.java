import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class study032201 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String road = br.readLine();

        solution(n,road);

    }

    private static void solution(int n,String road) {
        PriorityQueue<Genre> que = new PriorityQueue<>();
        



    }

    private static class Genre implements Comparable<Genre>{
        String name;
        float score;
        Genre(String name,float score){
            this.name =name;
            this.score=score;
        }
        @Override
        public int compareTo(Genre other) {
            if(this.score>other.score)return 1;
            else if(this.score<other.score) return -1;
            return 1;
        }
    }
}
