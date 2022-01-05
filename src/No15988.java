import java.util.Scanner;

public class No15988 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n = 0;
        long[] dp = new long[1000001];
        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 4L;
        for (int i = 0; i < t; i++){
            n = scanner.nextInt();
            if (dp[n] == 0){
                for (int j = 4; j <= n; j++){
                    dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % 1000000009;
                }
            }
            System.out.println(dp[n]);
        }
    }
}
