import java.io.BufferedReader;
import java.io.InputStreamReader;

// 팰린드롬인지 확인하기
// https://www.acmicpc.net/problem/10988
public class Baekjoon10988 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int left = 0;
        int right = s.length() - 1;

        int result = 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                result = 0;
                break;
            }
            left++;
            right--;
        }

        System.out.println(result);
    }
}
