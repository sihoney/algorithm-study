package baekjoon.phase5.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

//카드2
//https://www.acmicpc.net/problem/2164
public class Card2_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            list.add(i);
        }
//        System.out.println("start: " + list.toString()); // [1, 2, 3, 4, 5, 6]

//        다음과 같은 동작을 카드가 한 장 남을 때까지 반복
        for(int i = 0; list.size() > 1; i++) {
            if(i % 2 == 0) {
//                제일 위에 있는 카드를 바닥에 버린다.
                list.removeFirst(); // [2, 3, 4, 5, 6]
            } else {
//                그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
                int card = list.removeFirst(); // 2, [3, 4, 5, 6]

                list.add(card); // [3, 4, 5, 6, 2]
            }
//            System.out.println(list.toString());
        }

        System.out.println(list.peek());
    }
}

/**
 * N장의 카드
 * 카드는 차례로 1부터 N까지의 번호가 붙어 있으며
 * 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태
 *
 * 다음과 같은 동작을 카드가 한 장 남을 때까지 반복
 * 제일 위에 있는 카드를 바닥에 버린다.
 * 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
 *
 * 제일 마지막에 남게 되는 카드를 구하는 프로그램
 */