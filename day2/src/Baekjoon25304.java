import java.io.BufferedReader;
import java.io.InputStreamReader;

// 영수증
// http://acmicpc.net/problem/25304
public class Baekjoon25304 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long X = Long.parseLong(br.readLine());
        int N = Integer.parseInt(br.readLine());

        long sum = 0;

        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            long price = Long.parseLong(parts[0]);
            long count = Long.parseLong(parts[1]);

            sum += price * count;
        }

        if (sum == X) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
