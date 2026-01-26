import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;

//회사에 있는 사람
//https://www.acmicpc.net/problem/7785
public class Company_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 출입 기록의 수

        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            String name_new = arr[0];
            String state_new = arr[1];

            if(map.containsKey(name_new)) {
//                String state_before = map.get(name_new);

                if(state_new.equals("leave")) {
                    map.remove(name_new);
                } else {
                    map.put(name_new, state_new);
                }
            } else {
                map.put(name_new, state_new);
            }
        }

//        map.entrySet().stream().forEach(System.out::println);

        map.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .forEach((s) -> sb.append(s).append("\n"));

        System.out.println(sb.toString());
    }
}

/**
 *  로그가 주어졌을 때, 현재 회사에 있는 모든 사람을 구하는 프로그램
 *  출입 기록의 수 n,  (2 ≤ n ≤ 106)
 *  각 사람의 이름이 주어지고 "enter"나 "leave"가 주어진다.
 *  대소문자가 다른 경우에는 다른 이름
 *  사전 순의 역순으로 한 줄에 한 명씩 출력
 */
