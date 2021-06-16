import java.util.*;

public class No14502 {

    static int n;
    static int m;
    static int[][] map;
    static int[][] copy;
    static int max;
    static List<Loca> virusList = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Loca{
        int x, y;
        public Loca(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] st;
        st = scanner.nextLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        map = new int[n][m];
        copy = new int[n][m];

        for (int i = 0; i < n; i ++){
            st = scanner.nextLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st[j]);
                if(map[i][j] == 2){
                    virusList.add(new Loca(i,j));
                }
            }
        }

        setWall(0,0);
        System.out.println(max);
    }

    static void setWall(int start, int depth){
        int safe;
        if(depth == 3) {
            setCopy();
            for(Loca loca : virusList) {
                spread(loca.x, loca.y);
            }
            safe = checkArea();
            if(max < safe)
                max = safe;
            return;
        }

        for(int i = start; i < n * m; i++){
            int x = i / m;
            int y = i % m;

            if(map[x][y] == 0){
                map[x][y] = 1;
                setWall(i + 1, depth + 1);
                map[x][y] = 0;
            }
        }

    }

    static void spread(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < n && 0 <= ny && ny < m){
                if(copy[nx][ny] == 0){
                    copy[nx][ny] = 2;
                    spread(nx, ny);
                }
            }
        }
    }

    static int checkArea(){
        int area = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(copy[i][j] == 0){
                    area++;
                }
            }
        }
        return area;
    }

    static void setCopy(){
        for (int i = 0; i < n; i ++){
            for(int j = 0; j < m; j++){
                copy[i][j] = map[i][j];
            }
        }
    }
}
