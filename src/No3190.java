import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No3190 {

    static class Dire{
        int x;
        char c;
        public Dire(int x, char c) {
            this.x = x;
            this.c = c;
        }
    }

    static int n, k, l;
    static int[][] map;
    static List<Dire> direList;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        k = Integer.parseInt(scanner.nextLine());
        int x, y, t;
        char c;
        String[] st;

        for(int i = 0; i < k; i++){
            st = scanner.nextLine().split(" ");
            x = Integer.parseInt(st[0]);
            y = Integer.parseInt(st[1]);
            map[x][y] = 1;
        }

        l = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < l; i++){
            st = scanner.nextLine().split(" ");
            t = Integer.parseInt(st[0]);
            c = st[1].charAt(0);
            direList.add(new Dire(t, c));
        }

    }
}
