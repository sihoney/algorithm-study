package baekjoon.phase5.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//큐
//https://www.acmicpc.net/problem/10845
public class Queue_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 명령의 수

        int[] arr = new int[N];
        int head = 0;
        int tail = 0;
        int size = 0;

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            String cmd = line[0];
            int x = 0;
            if(line.length > 1) x = Integer.parseInt(line[1]);

            switch(cmd) {
                case "push":
                    // 정수 X를 큐에 넣는 연산이다.
                    arr[tail] = x;

                    tail = (tail + 1) % N;

                    size++;

                    break;
                case "pop":
                    // 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다.
                    // 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
                    if(size == 0) {
                        sb.append(-1).append("\n");
                        break;
                    }

                    sb.append(arr[head]).append("\n");

                    arr[head] = 0;

                    head = (head + 1) % N;

                    size--;

                    break;
                case "size":
                    // 큐에 들어있는 정수의 개수를 출력
                    sb.append(size).append("\n");

                    break;
                case "empty":
                    // 큐가 비어있으면 1, 아니면 0을 출력
                    if(size == 0) {
                        sb.append(1).append("\n");
                        break;
                    }
                    sb.append(0).append("\n");

                    break;
                case "front":
                    // 큐의 가장 앞에 있는 정수를 출력
                    // 큐에 들어있는 정수가 없는 경우에는 -1을 출력
                    if(size == 0) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(arr[head]).append("\n");

                    break;
                case "back":
                    // 큐의 가장 뒤에 있는 정수를 출력
                    // 큐에 들어있는 정수가 없는 경우에는 -1을 출력
                    if(size == 0) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(arr[tail - 1]).append("\n");

                    break;
            }
        }

        System.out.println(sb.toString());
    }
}

/**
 * 큐를 구현, 입력으로 주어지는 명령을 처리
 *
 * push X: 정수 X를 큐에 넣는 연산이다.
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 큐에 들어있는 정수의 개수를 출력한다.
 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
