import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 행렬 덧셈
// https://www.acmicpc.net/problem/2738
public class MatrixSum_2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);

        int[][] result = new int[N][M];

        for(int r = 0; r < N * 2; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int c = 0; c < M; c++) {
                result[r % N][c] += Integer.parseInt(st.nextToken());

                if(r >= N) {
                    sb.append(result[r % N][c]);
                    sb.append(" ");
                }
            }

            if(r >= N) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}

/**
 * 1. 메모리 구조
 * Stack:
 * main()
 *  ├─ N, M
 *  ├─ r, c
 *  └─ st
 *
 * Heap:
 * int[N][M] result   // 결과 상태
 * StringTokenizer
 * StringBuilder
 *
 * 2. 시간 복잡도
 * 입력 처리: 2 × N × M
 * 연산: 덧셈 2 × N × M
 * 출력: N × M
 *
 * 총합: O(N × M)
 *
 */
