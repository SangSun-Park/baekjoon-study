import java.util.*;

public class No11726 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (n > 1){
            for(int i = 2; i <= n; i++){
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }
        }
        System.out.println(dp[n]);
    }
}
