import java.util.Scanner;

public class No11727 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}
