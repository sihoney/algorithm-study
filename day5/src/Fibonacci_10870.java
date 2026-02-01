import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//피보나치 수 5
//https://www.acmicpc.net/problem/10870
public class Fibonacci_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(N));
    }

    static int fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

/**
 * n = 10
 * fibo(9) + fibo(8)
 * fibo(8) + fibo(7) + fibo(7) + fibo(6)
 * 7 + 6 + 6 + 5 + 6 + 5 + 5 + 4
 *
 */
