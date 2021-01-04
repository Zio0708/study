import java.io.*;
import java.util.ArrayList;

public class FileReadingTest {
    public static void main(String[] args){
        try{
            //파일 객체 생성
            File file = new File("D:\\KJH\\S\\2020\\test\\Sample.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String lines = "";
            String line ="";
            ArrayList<String> ary = new ArrayList<>();
            while((line = bufReader.readLine()) != null){
                ary.add(line);
            }
            System.out.println(ary);
            //.readLine()은 끝에 개행문자를 읽지 않는다.
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
    }
}