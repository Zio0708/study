public class dynamic01 {
    public static void main(String[] args){
        int result = fibonazi(6);
        System.out.println(result);
    }

    private static int fibonazi(int i) {
        //어떻게 왔니
        //1일때는 1
        //2일때는 1
        //3부터는 그전의 두개를 더하는 값
        int result;
        if(i==1){return 0;}
        else if(i==2){return 1;}
        else {
            result = fibonazi(i - 1) * fibonazi(i - 1) + fibonazi(i - 2);
        }
        return result;
    }
}
