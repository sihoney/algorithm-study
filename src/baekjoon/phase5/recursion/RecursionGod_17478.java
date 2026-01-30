package baekjoon.phase5.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//재귀함수가 뭔가요?
//https://www.acmicpc.net/problem/17478
public class RecursionGod_17478 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");

        String prefix = "";
        recursion(N, prefix);

        System.out.println(sb.toString());
    }

    static void recursion(int n, String prefix) {
        sb.append(prefix).append("\"재귀함수가 뭔가요?\"").append("\n");

        // 2. 기저 조건: 특정 깊이에 도달했을 때 반복을 멈추고 답을 내놓음
        if(n == 0) {
            sb.append(prefix).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n")
                    .append(prefix).append("라고 답변하였지.").append("\n");
            return;
        } else {
            // 1. 재귀 호출: 자기 자신과 똑같은 이야기를 다시 시작함
            sb.append(prefix).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n")
                    .append(prefix).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n")
                    .append(prefix).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");

            recursion(n - 1, prefix + "____");
        }

        // 3. 스택 복귀: 쌓였던 호출들이 차례대로 종료되며 빠져나옴
        sb.append(prefix).append("라고 답변하였지.").append("\n");
    }
}

/**
 * 교수님이 출력을 원하는 재귀 횟수 N(1 ≤ N ≤ 50)
 * 출력 예시를 보고 재귀 횟수에 따른 챗봇의 응답을 출력
 *
 * n = 4
 * 어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.
 *
 * "재귀함수가 뭔가요?"
 * "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
 * 마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
 * 그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
 *
 * ____"재귀함수가 뭔가요?"
 * ____"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
 * ____마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
 * ____그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
 *
 * ________"재귀함수가 뭔가요?"
 * ________"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
 * ________마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
 * ________그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
 *
 * ____________"재귀함수가 뭔가요?"
 * ____________"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
 * ____________마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
 * ____________그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
 *
 * ________________"재귀함수가 뭔가요?"
 * ________________"재귀함수는 자기 자신을 호출하는 함수라네"
 * ________________라고 답변하였지.
 *
 * ____________라고 답변하였지.
 * ________라고 답변하였지.
 * ____라고 답변하였지.
 * 라고 답변하였지.
 */
