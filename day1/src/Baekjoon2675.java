import java.util.Scanner;

// 문자열 반복
// https://www.acmicpc.net/problem/2675
public class Baekjoon2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        for(int i = 0; i < c; i++){
            int p = sc.nextInt(); // 3
            String str = sc.next(); // abc

            for(int j = 0; j < str.length(); j++){
                for(int t = 0; t < p; t++) {
                    System.out.print(str.charAt(j));
                }
            }

            System.out.println();
        }
    }
}