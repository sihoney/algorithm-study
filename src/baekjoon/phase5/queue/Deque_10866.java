package baekjoon.phase5.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//덱
//https://www.acmicpc.net/problem/10866
public class Deque_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 명령의 수

        int[] arr = new int[N];
        int head = 0; // 첫 번째 요소의 인덱스
        int tail = 0; // 마지막 요소의 다음 빈 칸
        int size = 0; // 데크에 저장된 요소의 개수

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            String cmd = line[0];
            int x = 0;
            if (line.length > 1) x = Integer.parseInt(line[1]);

            switch (cmd) {
                case "push_front":
                    // 정수 X를 덱의 앞에 넣는다.
                    int front = (head - 1 + N) % N;
                    arr[front] = x;

                    head = front;

                    size++;

                    break;
                case "push_back":
                    // 정수 X를 덱의 뒤에 넣는다.
                    arr[tail] = x;

                    tail = (tail + 1) % N;

                    size++;

                    break;
                case "pop_front":
                    // 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력
                    // 덱에 들어있는 정수가 없는 경우에는 -1을 출력
                    if(size == 0) {
                        sb.append(-1).append("\n");
                        break;
                    }

                    sb.append(arr[head]).append("\n");

                    arr[head] = 0;

                    head = (head + 1) % N;

                    size--;

                    break;
                case "pop_back":
                    // 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력
                    // 덱에 들어있는 정수가 없는 경우에는 -1을 출력
                    if(size == 0) {
                        sb.append(-1).append("\n");
                        break;
                    }

                    sb.append(arr[(tail - 1 + N) % N]).append("\n");

                    arr[(tail - 1 + N) % N] = 0;

                    tail = (tail - 1 + N) % N;

                    size--;

                    break;
                case "size":
                    // 덱에 들어있는 정수의 개수를 출력
                    sb.append(size).append("\n");

                    break;
                case "empty":
                    // 덱이 비어있으면 1을, 아니면 0을 출력
                    if(size == 0) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }

                    break;
                case "front":
                    // 덱의 가장 앞에 있는 정수를 출력
                    // 덱에 들어있는 정수가 없는 경우에는 -1을 출력
                    if(size == 0) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(arr[head % N]).append("\n");

                    break;
                case "back":
                    // 덱의 가장 뒤에 있는 정수를 출력
                    // 덱에 들어있는 정수가 없는 경우에는 -1을 출력
                    if(size == 0) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(arr[(tail - 1 + N) % N]).append("\n");

                    break;
            }
        }

        System.out.println(sb.toString());
    }
}

/**
 * 덱(Deque)를 구현
 * push_front X: 정수 X를 덱의 앞에 넣는다.
 * push_back X: 정수 X를 덱의 뒤에 넣는다.
 * pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 덱에 들어있는 정수의 개수를 출력한다.
 * empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 * front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *
 * <인덱스 이동 규칙>
 * - 오른쪽 이동:
 * - 왼쪽 이동:
 */
