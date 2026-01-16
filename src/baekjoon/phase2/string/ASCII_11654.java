package baekjoon.phase2.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 아스키 코드
// https://www.acmicpc.net/problem/11654
public class ASCII_11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(br.read());
    }
}

/**
 * Q. 이게 왜 되는 걸까?
 * System.out.println(br.read());
 *
 * 🔍 br.read()는 정확히 뭘 반환하나
 * BufferedReader.read()의 '반환 타입은 int'다.
 *
 * 이 메서드는 내부적으로 이렇게 동작한다:
 * - 입력 스트림에서 문자 하나를 읽는다
 * - 그 문자의 유니코드(정수 값) 를 반환한다
 *
 * 1. 메모리 구조
 * Stack:
 * main()
 *  └─ (반환값 int)
 *
 * Heap:
 * BufferedReader
 *  └─ 내부 char buffer
 *
 * 2. 시간 복잡도
 * read(): O(1)
 * 전체: O(1)
 */