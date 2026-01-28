package baekjoon.phase5.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//제로
//https://www.acmicpc.net/problem/10773
public class Zero_10773
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> records = new Stack<>();

        for(int i = 0; i < K; i++) {
            int record = Integer.parseInt(br.readLine());

            if(record == 0) {
                records.pop();
            } else {
                records.add(record);
            }
        }

        int sum = 0;
        for(Integer r : records) {
            sum += r;
        }

        System.out.println(sum);
    }
}
