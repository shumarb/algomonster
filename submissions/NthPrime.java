// Question: https://algo.monster/problems/nth_prime

import java.util.Arrays;
import java.util.Scanner;

class NthPrime {
    public static int nthPrime(int n) {
        boolean[] isPrime = new boolean[100001];
        int count = 0;

        Arrays.fill(isPrime, 2, 100001, true);
        for (int i = 2; i * i <= 100000; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= 100000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= 100000; i++) {
            if (isPrime[i] && ++count == n) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = nthPrime(n);
        System.out.println(res);
    }
}
