import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//붙임성 좋은 총총이
//https://www.acmicpc.net/problem/26069
public class ChongChong_26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 사람들이 만난 기록의 수

        ArrayList<String>[] graph = new ArrayList[N];
        for(int i = 0; i < N; i++) graph[i] = new ArrayList<String>();

        // N개의 줄에 걸쳐 사람들이 만난 기록
        // 총총이의 이름은 ChongChong으로 주어지며, 기록에서 1회 이상 주어진다.
        // 대소문자를 구분
        // 무지개 댄스를 추는 사람의 수를 출력

        for(int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            String p1 = arr[0];
            String p2 = arr[1];


        }
    }
}
