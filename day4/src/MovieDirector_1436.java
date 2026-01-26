import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//영화감독 숌
//https://www.acmicpc.net/problem/1436
public class MovieDirector_1436 {
    public static void main_01(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // "666" 포함, N번째로 큰 수

        int count = 1;
        int i = 666;

        while(count < N) {
            i++;

            if(String.valueOf(i).contains("666")) {
                count++;
            }
        }

        System.out.println(i);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 10,000보다 작거나 같은 자연수

        String str = "666";
        int cnt = 0;
        int state;

        for(int n = 0; cnt <= N; n++) {
            // str 앞 또는 뒤에 숫자를 크게 함
            // 두 개 더해보고 전(n - 1) 숫자와 차가 적은 것을 선택
            // 상태를 어떻게 저장하지? 666과 그 외의 숫자를 어떻게 분리하지?


            cnt++;
        }

//        System.out.println(state);
    }
}
