package baekjoon.phase3.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 크로아티아 알파벳
// https://www.acmicpc.net/problem/2941
public class CroatianAlphabet_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word = br.readLine().toCharArray();

        int idx = 0;
        int count = 0;

        while(idx < word.length) {
            char c = word[idx];

            if(c == 'c') {
                if(idx + 1 < word.length && (word[idx + 1] == '-' || word[idx + 1] == '=')) {
                    count++;
                    idx+=2;
                    continue;
                }
            }

            if(c == 'l' || c == 'n') {
                if(idx + 1 < word.length && word[idx + 1] == 'j') {
                    count++;
                    idx+=2;
                    continue;
                }
            }

            if(c == 's' || c == 'z') {
                if(idx + 1 < word.length && word[idx + 1] == '=') {
                    count++;
                    idx+=2;
                    continue;
                }
            }

            if(c == 'd') {
                if(idx + 1 < word.length && word[idx + 1] == '-') {
                    count++;
                    idx+=2;
                    continue;
                }

                if(idx + 2 < word.length && word[idx + 1] == 'z' && word[idx + 2] == '=') {
                    count++;
                    idx+=3;
                    continue;
                }
            }

            idx++;
            count++;
        }

        System.out.println(count);
    }

    public static void main_wrong(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word = br.readLine().toCharArray();

        int idx = 0;
        int count = 0;

        while(idx < word.length) {
            char c = word[idx];

            if(c == 'j') {
                if(idx - 1 >= 0 && (word[idx - 1] == 'n' || word[idx - 1] == 'l')) {
                    idx++;
                    continue;
                }
            }

            if(c == '-') {
                if(idx - 1 >= 0 && (word[idx - 1] == 'c' || word[idx - 1] == 'd')) {
                    idx++;
                    continue;
                }
            }

            if(c == '=') {
                if(idx - 1 >= 0 && (word[idx - 1] == 'c' || word[idx - 1] == 's')) {
                    if(idx - 2 >= 0 && word[idx - 2] == 'd') {
                        count--;
                        idx++;
                        continue;
                    }
                    idx++;
                    continue;
                }
            }

            idx++;
            count++;
        }

        System.out.println(count);
    }
}

/**
 *  c=      x
 *  s=      x
 *  z=      x
 *  dz=     x
 *  c-      x
 *  d-      x
 *  lj      x
 *  nj      x
 *
 * -, =, j 만 검사
 *
 *
 * ljes=njak
 * lj e s= nj a k
 * 6
 *
 * ddz=z=
 * d dz= z=
 * 3
 *
 * 문자열 + 상태
 * “이전 값 기억” 패턴
 */
