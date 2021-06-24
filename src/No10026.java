import java.util.Scanner;

public class No10026 {
    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        map = new char[n][n];
        visited = new boolean[n][n];
        int count1 = 0, count2 = 0;
        String st;
        for(int i = 0; i < n; i++){
            st = scanner.nextLine();
            for(int j = 0; j < n; j++){
                map[i][j] = st.charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    count1++;
                    nor(i, j);
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 'R'){
                    map[i][j] = 'G';
                }
            }
        }

        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    count2++;
                    nor(i, j);
                }
            }
        }

        System.out.println(count1 + " " + count2);
    }

    static void nor(int x, int y){
        char color = map[x][y];
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nextx = x + dx[i];
            int nexty = y + dy[i];

            if(nextx < 0 || nexty < 0 || nextx >= n || nexty >= n){
                continue;
            }

            if(visited[nextx][nexty]){
                continue;
            }
            char nextColor = map[nextx][nexty];
            if(nextColor == color){
                nor(nextx, nexty);
            }
        }
    }
}
