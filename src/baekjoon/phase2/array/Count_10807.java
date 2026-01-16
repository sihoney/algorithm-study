package baekjoon.phase2.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 개수 세기
// https://www.acmicpc.net/problem/10807
public class Count_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());

//        IntStream intStream = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt);
//        대체 풀이 [메모리 절약 버전]
        String[] tokens = br.readLine().split(" ");

        Integer v = Integer.parseInt(br.readLine());

//        long count = intStream.filter(n -> n == v).count();
//        대체 풀이 [메모리 절약 버전]
        int count = 0;
        for(String s : tokens) {
            if(Integer.parseInt(s) == v) count++;
        }

        System.out.println(count);
    }
}

/**
 * 1. 구조 선택 평가
 * 이 방식의 의미:
 * - 배열 생성 → String[]
 * - 다시 IntStream으로 변환
 * - filter → count
 *
 * 논리적으로 매우 깔끔,
 * 하지만 메모리와 성능 관점에선 비용이 있다.
 *
 * 메모리 그림으로 보면:
 * Heap:
 * String[] tokens
 * IntStream 내부 파이프라인 구조
 * -> 객체가 꽤 많이 생긴다.
 *
 * 2. 데이터 구조
 * - 입력 정수: String[] → Heap
 * - IntStream 파이프라인 객체들 → Heap
 * - n, v, count → Stack
 *
 * 3. 메모리 스케치
 * Stack:
 * main()
 *  ├─ N
 *  ├─ v
 *  ├─ count
 *  └─ intStream (reference)
 *
 *  Heap:
 * String[] tokens
 * IntPipeline / Sink / Node ... (Stream 내부 객체들)
 *
 * 4. 시간 복잡도
 * split: O(N)
 * mapToInt: O(N)
 * filter + count: O(N)
 *
 * 총합: O(N)
 */
