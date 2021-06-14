import java.util.*;

public class No9663 {

    public static int[] board;
    public static int count;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        count = 0;
        board = new int[n];
        for(int i = 0; i < n; i++){
            board[0] = i;
            findCount(n, 1);
        }

        System.out.println(count);
    }

    private static void findCount(int n, int row){
        if (row >= n-1){
            count ++;
            return;
        }

        for (int i = 0; i < n; i++){
            board[row] = i;
            if(check(row)){
                findCount(n,row + 1);
            }
        }
    }

    private static boolean check(int row){
        for (int i = 0; i <= row; i++){
            if(board[i] == board[row] || row - i == Math.abs(board[row] - board[i]))
                return false;
        }
        return true;
    }
}
