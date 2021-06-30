import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No3190 {

    static class Dire{
        int x;
        int d;
        public Dire(int x, int d) {
            this.x = x;
            this.d = d;
        }
    }

    static int n, k, l;
    static int[][] map;
    static List<Dire> direList;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static List<int[]> snake;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        k = Integer.parseInt(scanner.nextLine());
        int x, y, t;
        char c;
        String[] st;

        map = new int[n][n];

        for(int i = 0; i < k; i++){
            st = scanner.nextLine().split(" ");
            x = Integer.parseInt(st[0]);
            y = Integer.parseInt(st[1]);
            map[x - 1][y - 1] = 1;
        }

        l = Integer.parseInt(scanner.nextLine());

        direList = new ArrayList<>();
        snake = new ArrayList<>();
        for(int i = 0; i < l; i++){
            st = scanner.nextLine().split(" ");
            t = Integer.parseInt(st[0]);
            c = st[1].charAt(0);
            if (c == 'L')
                direList.add(new Dire(t, -1));
            else
                direList.add(new Dire(t, 1));
        }

        System.out.println(playGame(0, 0, 0));

    }

    public static int playGame(int x, int y, int d){
        int time = 0;
        int turn = 0;

        while (true){
            time++;
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if(!Finish(nextX, nextY))
                break;

            if(map[nextX][nextY] == 2){
                snake.add(new int[]{nextX, nextY});
            }else {
                snake.add(new int[]{nextX,nextY});
                snake.remove(0);
            }

            x = nextX;
            y = nextY;

            if (turn < l){
                if(time == direList.get(turn).x){
                    int nextD = (d + direList.get(turn).d) % 4;
                    if (nextD == -1)
                        d = 3;
                    else
                        d = nextD;
                    turn++;
                }
            }
        }
        return time;
    }

    public static boolean Finish(int x, int y){
        if(x == -1 || x == n || y == -1 || y == n)
            return false;
        for(int i = 0; i < snake.size(); i++){
            int[] s = snake.get(i);
            if (s[0] == x && s[1] == y)
                return false;
        }
        return true;
    }
}
