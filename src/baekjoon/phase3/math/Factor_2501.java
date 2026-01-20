package baekjoon.phase3.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 약수 구하기
// https://www.acmicpc.net/problem/2501
public class Factor_2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1 <= n <= 10000
        int k = Integer.parseInt(st.nextToken()) - 1; // n의 약수들 중 k번째로 작은 수, index값으로 변경

        int count = 0;
        for(int f = 1; f < n; f++) {

            if(n % f == 0) { // n의 약수
                count++;

                if(count == k) { // k번째 약수
                    System.out.println(f);
                    break;
                }
            }
        }
    }

    public static void main_before(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1 <= n <= 10000
        int k = Integer.parseInt(st.nextToken()) - 1; // n의 약수들 중 k번째로 작은 수, index값으로 변경

        List<Integer> factors = findFactor(n); // 1,2,3,6

        if(k > factors.size()) System.out.println(0);
        else System.out.println(factors.get(k));
    }

    static List<Integer> findFactor(int n) {
        List<Integer> factors = new ArrayList<>();

        for(int f = 1; f <= n / 2; f++) {
            if(n % f == 0) {
                factors.add(f);
            }
        }

        factors.add(n);

        return factors;
    }
}
