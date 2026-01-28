package baekjoon.phase5.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//스택 2
//https://www.acmicpc.net/problem/28278
public class Stack2_28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 명령의 수 N

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            String line = br.readLine();

            String[] arr = line.split(" ");
            int cmd = Integer.parseInt(arr[0]);
            int x = 0;
            if(arr.length > 1) x = Integer.parseInt(arr[1]);

            switch(cmd) {
                case 1:
                    // 정수 X를 스택에 넣는다
                    stack.push(x);

                    break;
                case 2:
                    // 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다.
                    // 없다면 -1을 대신 출력
                    if(!stack.isEmpty()) {
                        sb.append(stack.pop()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }

                    break;
                case 3:
                    // 스택에 들어있는 정수의 개수를 출력
                    sb.append(stack.size()).append("\n");

                    break;
                case 4:
                    // 스택이 비어있으면 1, 아니면 0을 출력
                    if(stack.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }

                    break;
                case 5:
                    // 스택에 정수가 있다면 맨 위의 정수를 출력한다.
                    // 없다면 -1을 대신 출력
                    if(!stack.isEmpty()) {
                        sb.append(stack.peek()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }

                    break;
            }
        }

        System.out.println(sb.toString());
    }
}

/**
 * 1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
 * 2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
 * 3: 스택에 들어있는 정수의 개수를 출력한다.
 * 4: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * 5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
 *
 * 출력을 요구하는 명령이 주어질 때마다 명령의 결과를 한 줄에 하나씩 출력
 */