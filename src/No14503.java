import java.util.*;

public class No14503 {

    static int n, m, r, c, d;
    static int[][] room;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] st = scanner.nextLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        st = scanner.nextLine().split(" ");
        r = Integer.parseInt(st[0]);
        c = Integer.parseInt(st[1]);
        d = Integer.parseInt(st[2]);

        room = new int[n][m];

        for (int i = 0; i < n; i++){
            st = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++){
                room[i][j] = Integer.parseInt(st[j]);
            }
        }

        room[r][c] = 2;
        System.out.println(findAnswer(1));
    }

    static int findAnswer(int answer){
        if(!check())
            return answer;

        room[r][c] = 2;
        return findAnswer(answer + 1);
    }

    static boolean check(){
        for (int i = 0; i < 4; i++){
            if(turn()) {
                d = (4 + (d-1)) % 4;
                return true;
            }
            d = (4 + (d-1)) % 4;
        }
        if(move())
            if(check())
                return true;

        return false;
    }

    static boolean move(){
        if (d == 0){
            if (room[r + 1][c] != 1) {
                r += 1;
                return true;
            }
        }
        else if (d == 1){
            if (room[r][c - 1] != 1){
                c -= 1;
                return true;
            }
        }
        else if (d == 2){
            if (room[r - 1][c] != 1){
                r -= 1;
                return true;
            }
        }
        else if (d == 3){
            if (room[r][c + 1] != 1){
                c += 1;
                return true;
            }
        }
        return false;
    }

    static boolean turn(){
        if (d == 0){
            if (room[r][c - 1] == 0) {
                c -= 1;
                return true;
            }
        }
        else if (d == 1){
            if (room[r - 1][c] == 0){
                r -= 1;
                return true;
            }
        }
        else if (d == 2){
            if (room[r][c + 1] == 0){
                c += 1;
                return true;
            }
        }
        else if (d == 3){
            if (room[r + 1][c] == 0){
                r += 1;
                return true;
            }
        }
        return false;
    }
}
