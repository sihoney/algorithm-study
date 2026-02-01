import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

//붙임성 좋은 총총이
//https://www.acmicpc.net/problem/26069
public class ChongChong_26069 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 기록의 수

        HashSet<String> peopleDancing = new HashSet<>();
        peopleDancing.add("ChongChong");

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            String b = st.nextToken();

            if(peopleDancing.contains(a) || peopleDancing.contains(b)) {
                peopleDancing.add(a);
                peopleDancing.add(b);
            }
        }

        System.out.println(peopleDancing.size());
    }
}
