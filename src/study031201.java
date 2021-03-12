public class study031201 {
    public static void main(String[] args){
        int[] answer= new int[9];
        int[] mon={50000,10000,5000,1000,500,100,50,10,1};
        int money=40005;
        answer[0]=money/ mon[0];
        money %= mon[0];
        for(int i = 1;i<mon.length;i++){
            answer[i]=money/ mon[i];
            money %=mon[i];
        }
        System.out.println(answer);
    }
}
