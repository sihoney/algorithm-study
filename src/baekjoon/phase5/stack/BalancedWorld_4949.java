package baekjoon.phase5.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//균형잡힌 세상
//https://www.acmicpc.net/problem/4949
public class BalancedWorld_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while(!(str = br.readLine()).equals(".")) {
            char[] line = str.toCharArray(); // string -> char[]

            boolean result = isBalanced(line);

            sb.append(result ? "yes" : "no").append("\n");
        }

        System.out.println(sb.toString());
    }

    static boolean isBalanced(char[] line) {
        Stack<Character> stack = new Stack<>();

        boolean result = true;
        for(char c : line) {
            if(c == '(' || c == '[') {
                stack.add(c);

            } else if(c == ')') {
                if(stack.isEmpty()) {
                    result = false;
                    break;
                }
                if(stack.peek() == '(') {
                    stack.pop();
                } else {
                    result = false;
                    break;
                }
            } else if(c == ']') {
                if(stack.isEmpty()) {
                    result = false;
                    break;
                }

                if(stack.peek() == '[') {
                    stack.pop();
                } else {
                    result = false;
                    break;
                }
            }
        }

        if(stack.isEmpty() && result) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * 괄호는 소괄호("()") 와 대괄호("[]")로 2종류,
 * 문자열이 균형을 이루는 조건
 * - 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재
 * - 1:1 매칭만 가능
 * - 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다.
 */
