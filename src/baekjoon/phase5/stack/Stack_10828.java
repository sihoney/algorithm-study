package baekjoon.phase5.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//스택
//https://www.acmicpc.net/problem/10828
public class Stack_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 명령의 수 N
        int[] stack = new int[N];
        int cursor = 0;

        for(int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            String cmd = arr[0];
            int x = 0;
            if(arr.length > 1) x = Integer.parseInt(arr[1]);

            switch(cmd) {
                case "push":
                    // 정수 X를 스택에 넣는 연산
                    stack[cursor] = x;
                    cursor++;

                    break;
                case "pop":
                    // 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력
                    // 스택에 들어있는 정수가 없는 경우에는 -1을 출력
                    if(cursor == 0) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(stack[cursor - 1]).append("\n");
                    stack[cursor] = 0;
                    cursor--;

                    break;
                case "size":
                    // 스택에 들어있는 정수의 개수를 출력
                    sb.append(cursor).append("\n");

                    break;
                case "empty":
                    // 스택이 비어있으면 1, 아니면 0을 출력
                    if(cursor == 0) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }

                    break;
                case "top":
                    // 스택의 가장 위에 있는 정수를 출력
                    // 스택에 들어있는 정수가 없는 경우에는 -1을 출력
                    if(cursor == 0) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(stack[cursor - 1]).append("\n");

                    break;
            }
        }

        System.out.println(sb.toString());
    }
}

/**
 * push X: 정수 X를 스택에 넣는 연산이다.
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 스택에 들어있는 정수의 개수를 출력한다.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
