import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 너의 평점은
// https://www.acmicpc.net/problem/25206
public class GPA_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 20;
        double scoreSum = 0;
        double creditSum = 0;

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if(grade.equals("P")) {
                continue;
            }

            double score = gradeToScore(grade);
            scoreSum += credit * score;
            creditSum += credit;
        }

        System.out.println(scoreSum / creditSum);
    }

    static double gradeToScore(String grade) {
        char[] arr = grade.toCharArray();

        double score = 0;

        switch(arr[0]) {
            case 'A':
                score += 4;
                break;
            case 'B':
                score += 3;
                break;
            case 'C':
                score += 2;
                break;
            case 'D':
                score += 1;
                break;
        }

        if(arr.length > 1 && arr[1] == '+') score += 0.5;

        return score;
    }
}

/**
 * 각 과목의 “중요도(학점)”만큼
 * “성취도(등급 점수)”를 반영한 평균
 *
 * 즉,
 * 학점 = 가중치
 * 등급 = 점수
 * GPA = 가중 평균
 *
 *
 */
