public class leetcode022303 {
    public String intToRoman(int num) {
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
        String answer="";
        int front;
        int back;
        String roman="";
        int cnt=0;
        if(num >= 1000 && num <=3999){
            cnt = num/1000;
            roman="M";
            num = num %1000;
        }
        if(num >= 500 && num <= 999){
            cnt = num/500;
            roman="M";
            num = num %1000;
        }
        if(num>= 100 && num <= 499){
            cnt = num/100;
            roman="M";
            num = num %1000;
        }
        if(num >= 50 && num <= 99){
            cnt = num/50;
            roman="M";
            num = num %1000;
        }
        if(num >=10 && num <= 49){
            cnt = num/10;
            roman="M";
            num = num %1000;
        }
        if(num >=5 && num <= 9){
            cnt = num/5;
            roman="M";
            num = num %1000;
        }
        if(num>=1 && num <=4){
            cnt = num/1;
            roman="M";
            num = num %1000;
        }
        for(int i = 0 ; i  < cnt ; i ++){
            answer+=roman;
        }


        return "bad";
        //그냥 하드코딩이 더 빠르고 효율적임
    }

    private String makeWord2(int i, int i1) {

        return "bad";
    }
    //1000
    //100
    //10
    //1
    //나머지가 4일시 앞에다 1붙이기
}
