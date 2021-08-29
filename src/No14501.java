import java.util.Scanner;

public class No14501 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[][] works = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] input = scanner.nextLine().split(" ");
            works[i][0] = Integer.parseInt(input[0]);
            works[i][1] = Integer.parseInt(input[1]);
        }

        System.out.println(check(0, N, 1, 0, works));
    }

    private static int check(int idx, int n, int days, int cost, int[][] works) {
        if(days < idx)
            days = idx;
        if(idx >= n)
            return cost;
        if(idx + works[idx][0] - 1>= n || days >= n)
            return cost;
        if(days > idx + 1 || days + works[idx][0] - 1 > n)
            cost = Math.max(check(idx + 1, n, days, cost, works), cost);
        else {
            cost = Math.max(check(idx + 1, n, days + works[idx][0] - 1, cost + works[idx][1], works),
                    check(idx + 1, n, days, cost, works));
        }
        return cost;
    }
}
