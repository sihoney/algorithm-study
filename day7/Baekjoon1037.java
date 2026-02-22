package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon1037 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		// 개수가 짝수라면
		if(list.size() % 2 == 0) {
			sb.append(list.get(0) * list.get(list.size() - 1));
		}
		else { // 홀수라면
			sb.append((int) Math.pow(list.get(list.size() / 2), 2));
		}
		
		System.out.println(sb);
	}  
}
