import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//하노이 탑 이동 순서
//https://www.acmicpc.net/problem/11729
public class HanoiTower_11729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 원판의 개수 N (1 ≤ N ≤ 20)

        hanoi(3, 1, 2, 3);
    }

    static void hanoi(int n, int from, int via, int to) {
        if(n == 1) {
            return;
        }

//        for(int )
    }
}

