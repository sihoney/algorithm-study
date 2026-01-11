import java.io.IOException;
import java.util.Scanner;

// 1998년생인 내가 태국에서는 2541년생?!
// https://www.acmicpc.net/problem/18108
public class Baekjoon18108 {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        int y = in.nextInt();

        System.out.println(y - 543);
    }
}