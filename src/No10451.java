import java.util.Scanner;

public class No10451 {

    static boolean[] visited;
    static int n;
    static int[] br;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++){
            n = scanner.nextInt();
            br = new int[n + 1];
            visited = new boolean[n + 1];
            for (int j = 1; j <= n; j++){
                br[j] = scanner.nextInt();
            }
            check(br);
        }
    }

    private static void check(int[] br) {
        int count = 0;

        for (int i = 1; i <= n; i++){
            if (!visited[i]){
                int x = i;
                while (!visited[x]){
                    visited[x] = true;
                    x = br[x];
                }
                count++;
            }
        }

        System.out.println(count);
    }
}
