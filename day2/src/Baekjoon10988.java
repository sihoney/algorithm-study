import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10988 {

    public static int N;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        int repeat = word.length() / 2;
        if(word.length() % 2 != 0) {repeat += 1;}

        int result = 1;

        for(int i = 0; i < repeat; i++) {

            char a = word.charAt(i);
            char b = word.charAt(word.length() - 1 - i);

            if(a != b) {
                result = 0;
                break;
            }
        }

        System.out.println(result);
    }
}

