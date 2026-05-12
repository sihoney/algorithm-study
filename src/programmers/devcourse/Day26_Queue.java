package programmers.devcourse;

// day 26 - 1 큐
// https://school.programmers.co.kr/tryouts/207418/challenges?language=java
public class Day26_Queue {
	public static void main(String[] args) {
		String[] queries = {"I", "I", "I", "I", "O", "O", "O"};
		String[] names = {"one", "two", "three", "four", "-", "-", "-"};
		// ========================================================

		String[] queue = new String[queries.length];
		int head = 0;
		int tail = 0;

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < queries.length; i++) {
			if(queries[i].equals("I")) {
				queue[tail] = names[i];

				tail = (tail + 1) % queue.length;
			} else {
				String out = queue[head];

				if(out.length() % 2 == 0) {
					sb.append(out).append(" ");
				}

				queue[head] = null;
				head = (head + 1) % queue.length;
			}
		}

		String[] result = sb.toString().split(" ");
		if(result.length == 1 && result[0].equals("")) result = new String[0];
		for(int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}
}
