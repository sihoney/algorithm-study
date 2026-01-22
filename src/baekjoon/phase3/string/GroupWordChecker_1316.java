package baekjoon.phase3.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//그룹 단어 체커
//https://www.acmicpc.net/problem/1316
public class GroupWordChecker_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0; i < n; i++) {
            String word = br.readLine();

            if(isGroupWord(word)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean isGroupWord(String word) {

        boolean[] exists = new boolean[26];

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(!exists[c - 'a']) {
//              처음 등장한 문자의 경우
//                1. 상태 on
                exists[c - 'a'] = true;
            } else {
//                등장했던 문자의 경우
//                2. 연속된 문자인지 확인
                if(c == word.charAt(i - 1)) {
//                2-1. 연속된 문자 -> 다음으로 이동
                    continue;
                }

//                2-2. 연속된 문자 X -> false 반환
                return false;
            }
        }

        return true;
    }
}

/**
 * 그룹 단어란, 각 문자가 연속해서 나타나는 경우만
 *
 * word     length
 * happy    5
 * abab     4
 * aaaba    5
 */
