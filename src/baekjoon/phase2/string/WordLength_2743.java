package baekjoon.phase2.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordLength_2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(br.readLine().length());
    }
}

/**
 * 🧠 이 한 줄이 의미하는 것
 * br.readLine().length()
 *
 * 1. readLine() -> 한 줄을 읽어서 String 객체를 만든다.
 * 2. length() -> 그 String 내부의 문자 개수 필드를 바로 반환한다.
 *
 * 🧬 메모리 관점에서 보면
 * String은 내부적으로 이런 구조다:
 * String
 *  ├─ char[] value
 *  └─ int length
 *
 *  그래서 length()는 사실상:
 *  return this.length;
 *
 *  - 반복문 ❌
 * - 새 객체 생성 ❌
 * - O(1) 연산
 */
