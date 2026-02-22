package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baejoon28279 {
    	public static void main(String[] args) throws IOException {
		
  		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		StringTokenizer st;
		while(N > 0) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int value = 0;
			if(st.hasMoreTokens()) {
				value = Integer.parseInt(st.nextToken());
			}
			
			switch(command) {
			case 1 :
				deque.addFirst(value);
				break;
			case 2 : 
				deque.addLast(value);
				break;
			case 3 : 
				if(deque.size() > 0) {
					sb.append(deque.pollFirst()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
				break;
			case 4 :
				if(deque.size() > 0) {
					sb.append(deque.pollLast()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}				
				break;
			case 5 : 
				sb.append(deque.size()).append("\n");
				break;
			case 6 : 
				if(deque.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			case 7 :
				if(deque.size() > 0) {
					sb.append(deque.peekFirst()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}				
				break;
			case 8 : 
				if(deque.size() > 0) {
					sb.append(deque.peekLast()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}				
				break;
			}
			
			N--;
		}
		
		System.out.println(sb.toString());
	}    
}
