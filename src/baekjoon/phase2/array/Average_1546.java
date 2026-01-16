package baekjoon.phase2.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평균
// https://www.acmicpc.net/problem/1546
public class Average_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double max = 0;
        double sum = 0;
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            double v = Double.parseDouble(st.nextToken());
            sum += v;
            if(v > max) max = v;
        }

        System.out.println(sum / max * 100 / n);
    }

    public static void main_array(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double max = 0;
        double sum = 0;
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        double[] arr = new double[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(st.nextToken());

            if(arr[i] > max) max = arr[i];
        }

        for(double v : arr) {
            sum += v / max * 100;
        }

        System.out.println(sum / n);
    }
}

/**
 * 1. 메모리 구조
 * Stack:
 * main()
 *  ├─ n
 *  ├─ max
 *  ├─ sum
 *  ├─ i
 *
 * Heap:
 * double[n] arr
 * StringTokenizer
 *
 * 2. 시간 복잡도
 * 입력 + max 계산: O(n)
 * 정규화 + 합산: O(n)
 * 총합: O(n)
 */