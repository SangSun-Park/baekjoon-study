import java.util.Scanner;

public class No10844 {
    static long[][] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new long[n + 1][10];
        long answer = 0;
        for (int i = 0; i < 10; i++){
            dp[1][i] = 1L;
        }

        for (int i = 1; i < 10; i++){
            answer += recur(n, i);
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j < 10; j++){
                System.out.println(dp[i][j]);
            }
        }
        System.out.println(answer % 1000000000);
    }

    private static long recur(int n, int i) {
        if (n == 1) {
            return dp[n][i];
        }

        if (dp[n][i] == 0) {
            if (i == 0) {
                dp[n][i] = recur(n - 1, 1);
            } else if (i == 9) {
                dp[n][i] = recur(n - 1, 8);
            } else {
                dp[n][i] = recur(n - 1, i + 1) + recur(n - 1, i - 1);
            }
        }
        return dp[n][i] % 1000000000;
    }
}
