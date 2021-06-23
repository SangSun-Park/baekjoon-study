import java.util.Scanner;

public class No14500 {

    static int n, m;
    static int[][] arr;
    static int max;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] st = scanner.nextLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        arr = new int[n][m];
        visited = new boolean[n][m];
        max = 0;
        for(int i = 0; i < n; i++) {
            st = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                DFS(i, j, 0, 0);
                excep(i, j);
            }
        }

        System.out.println(max);
    }

    public static void DFS(int x, int y, int depth, int sum){
        if(depth == 4){
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextx = x + dx[i];
            int nexty = y + dy[i];

            if (nextx < 0 || nexty < 0 || nextx >= n || nexty >= m)
                continue;
            if (visited[nextx][nexty])
                continue;
            visited[nextx][nexty] = true;
            DFS(nextx, nexty, depth + 1, sum + arr[nextx][nexty]);
            visited[nextx][nexty] = false;
        }
    }

    public static void excep(int x, int y){
        int wing = 4;
        int min = Integer.MAX_VALUE;
        int sum = arr[x][y];

        for(int i = 0; i < 4; i++){
            int nextx = x + dx[i];
            int nexty = y + dy[i];

            if(wing <= 2)
                return;

            if(nextx < 0 || nexty < 0 || nextx >= n || nexty >= m){
                wing--;
                continue;
            }

            min = Math.min(min, arr[nextx][nexty]);
            sum = sum + arr[nextx][nexty];
        }

        if (wing == 4){
            sum -= min;
        }
        max = Math.max(max, sum);
    }
}
