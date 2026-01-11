import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon25304 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer X = Integer.parseInt(br.readLine()); // 총 금액

        Integer N = Integer.parseInt(br.readLine()); // 구매한 물건 종류의 수

        Integer A = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A += a * b;
        }

        if(X.equals(A)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

