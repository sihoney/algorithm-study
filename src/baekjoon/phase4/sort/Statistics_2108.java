package baekjoon.phase4.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//통계학
//https://www.acmicpc.net/problem/2108
public class Statistics_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // N은 홀수

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sb.append(findAvg(arr)).append("\n")
                .append(findMedian(arr)).append("\n")
                .append(findMode(arr)).append("\n");
//                .append(findRange(arr));

        System.out.println(sb.toString());
    }

    static int findMode(int[] arr) {
        int mode;

        // 최빈값
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        // Comparator를 사용하여 가장 큰 Value를 가진 Entry를 찾음
        int modeMax = map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .orElse(0);             // 맵이 비어있을 경우 기본값 0

        // 일단 최대 빈도수를 가지는 값들을 구해야 함
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer key : map.keySet()) {
            if(modeMax == map.get(key)) list.add(key);
        }

        // 정렬
        

        if(list.size() == 1) {
            mode = list.get(0);
        } else {
            mode = list.get(1);
        }

        return mode;
    }

    static int findMedian(int[] arr) {
        int median;

        // 정렬
        int count = 0; // 위치 변동 안 한 횟수
        while(count < arr.length - 1) {
            count = 0; // 초기화
            int accu = arr[0];

            for(int idx = 1; idx < arr.length; idx++) {
                int curr = arr[idx];

                if(accu > curr) {
                    arr[idx] = accu;
                    arr[idx - 1] = curr;
                } else {
                    count++;

                }

                accu = arr[idx];
            }
        }
        median = arr[(arr.length / 2)];

        return median;
    }

    static int findRange(int[] arr) {
        int range;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
        }
        range = Math.abs(max - min);

        return range;
    }

    static int findAvg(int[] arr) {
        double avg = 0;

        for(int i = 0; i < arr.length; i++) {
            avg += arr[i];
        }

        avg /= arr.length;
        // BigDecimal을 사용하여 소수점 0자리에서 반올림
        // HALF_UP 모드, 우리가 아는 일반적인 반올림(0.5일 때 절댓값이 커지는 쪽)을 수행합
        avg = new BigDecimal(String.valueOf(avg))
                .setScale(0, RoundingMode.HALF_UP)
                .longValue();

        return (int) avg;
    }
}

/**
 * N은 홀수
 * (1 ≤ N ≤ 500,000)
 *
 * 산술평균 : N개의 수들의 합을 N으로 나눈 값
 * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 최빈값 : N개의 수들 중 가장 많이 나타나는 값 (여러 개 있을 때에는 최빈값 중 두 번째로 작은 값)
 * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 *
 * 소수점 이하 첫째 자리에서 반올림한 값
 */