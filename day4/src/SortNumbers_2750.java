import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//수 정렬하기
//https://www.acmicpc.net/problem/2750
public class SortNumbers_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0; // 위치 변동 안 한 횟수

        while(count < N - 1) {
            int accu = arr[0];
            count = 0; // 초기화

            for(int idx = 1; idx < arr.length; idx++) {
                int curr = arr[idx];

                if(accu > curr) {
                    arr[idx] = accu;
                    arr[idx - 1] = curr;
                } else {
                    count++;
                }

                accu = arr[idx];
            }
        }

        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}

/**
 * N개의 수, 오름차순으로 정렬
 */
