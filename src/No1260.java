import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1260 {

    static int[][] br;
    static boolean[] visited;
    static int n;
    static int m;
    static int v;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        v = scanner.nextInt();
        br = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            br[x][y] = 1;
            br[y][x] = 1;
        }

        dfs(v);

        System.out.println();
        visited = new boolean[n + 1];

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        System.out.print(v + " ");

        while (!queue.isEmpty()){
            int tmp = queue.poll();

            for (int i = 1; i <= n; i++){
                if (!visited[i] && br[tmp][i] == 1){
                    queue.offer(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    private static void dfs(int q) {
        visited[q] = true;
        System.out.print(q + " ");

        for (int i = 1; i <= n; i++){
            if (!visited[i] && br[q][i] == 1)
                dfs(i);
        }
    }
}
