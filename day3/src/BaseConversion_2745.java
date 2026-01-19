import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 진법 변환
// https://www.acmicpc.net/problem/2745
public class BaseConversion_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken(); // 진법 수
        int B = Integer.parseInt(st.nextToken()); // 진법

        char[] arr = N.toCharArray();
        int result = 0;

        for(int i = 0; i < arr.length; i++) {
            int digit = alphaBase(arr[i]);
            result = result * B + digit;
        }

        System.out.println(result);
    }

    public static void main_before(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken(); // 진법 수
        int B = Integer.parseInt(st.nextToken()); // 진법

//        A 아스키 코드: 65 (10진법), B: 11, C: 12, ..., Z: 35
        char[] arr = N.toCharArray();
        int result = 0;

        for(int i = 0; i < arr.length; i++) {
            int place_value = arr.length - i;
            int digit = alphaBase(arr[i]);
            result += Math.pow(B, place_value - 1) * digit;
        }

        System.out.println(result);
    }

    static int alphaBase(char c) {
        if(Character.isLetter(c)) return c - 55;

        return c - '0';
    }
}