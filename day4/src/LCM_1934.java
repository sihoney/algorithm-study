import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//최소공배수
//https://www.acmicpc.net/problem/1934
public class LCM_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            sb.append(findLCM(a, b)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int findLCM(int a, int b) {
        int[] factors_a = findFactor(a);
        int[] factors_b = findFactor(b);

        int temp_a = 1;
        for(int f : factors_a) {
            temp_a *= f;
        }

        return 0;
    }

    static int[] findFactor(int n) {
        return new int[0];
    }
}

/**
 * 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)
 * (1 ≤ A, B ≤ 45,000)
 */