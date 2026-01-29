package baekjoon.phase5.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//별 찍기 - 1
//https://www.acmicpc.net/problem/2438
public class StarPrint01_2438 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        printStar(N);

        System.out.println(sb.toString());
    }

    static void printStar(int n) {
        if(n == 0) {
            return;
        }

        printStar(n - 1);

        // 여기서 n개의 별 출력
        for(int i = 0; i < n; i++) {
            sb.append("*");
        }
        sb.append("\n");
    }
}

/**
 * 1️⃣ 종료 조건은?
 * 줄 번호가 0이면 끝
 *
 * 2️⃣ 현재 호출은 무엇을 책임질까?
 * n번째 줄을 출력할 책임을 가진다.
 *
 * 3️⃣ 나머지는 누구에게 맡길까?
 * 1~(n-1)번째 줄은? 👉 이전 호출에게 맡긴다
 *
 * 🔑 이 문제의 핵심 아이디어
 * n번째 줄을 출력하려면
 * 먼저 1~(n-1)번째 줄이 출력되어 있어야 한다.
 */
