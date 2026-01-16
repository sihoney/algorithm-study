package baekjoon.phase2.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// X보다 작은 수
// https://www.acmicpc.net/problem/10871
public class LessThanX_10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        String[] arr = br.readLine().split(" ");
//        1. 많은 String 객체 생성 최소
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            if(v < x) {
//                System.out.print(a [i] + " ");
//                3. 매번 IO -> StringBuilder
                sb.append(v).append(' ');
            }
        }
        System.out.print(sb.toString());
    }

    public static void main_before(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" "); // Heap: String, String[] arr, 토큰 String 객체들
        Integer n = Integer.parseInt(arr[0]); // auto-boxing (int -> Integer) * Integer.parseInt -> int 반환
        Integer x = Integer.parseInt(arr[1]);

        String[] a = br.readLine().split(" "); // Heap: String, String[] a, 토큰 String 객체들

        for(int i = 0; i < a.length; i++) {
            if(Integer.parseInt(a[i]) < x) { // int < Integer (unboxing)
                System.out.print(a[i] + " ");
            }
        }
//        즉, 이 루프는:
//        - heap에 Integer 객체 존재
//        - 매 반복마다 언박싱 연산 발생
    }
}

/**
 * 1. 메모리
 * Heap:
 * String (첫 줄)
 * String[] arr
 * String (둘째 줄)
 * String[] a
 * 각 토큰 String 객체들
 *
 * "그리고 루프마다:"
 * Integer.parseInt(a[i])
 *
 * → 매번 새로운 Integer 객체 생성 가능성
 * → GC 압박 증가
 */