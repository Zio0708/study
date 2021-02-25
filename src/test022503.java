import java.util.LinkedList;
import java.util.Queue;

public class test022503 {
    Queue<String> pets = new LinkedList<>();
    public void accept(String petName) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        pets.add(petName);

    }

    public String heal() {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        return pets.poll();
    }

//    public static void main(String[] args) {
//        Veterinarian veterinarian = new Veterinarian();
//        veterinarian.accept("Barkley");
//        veterinarian.accept("Mittens");
//        System.out.println(veterinarian.heal());
//        System.out.println(veterinarian.heal());
//    }
}
