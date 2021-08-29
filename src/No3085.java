import java.util.Scanner;

public class No3085 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        char[][] board = new char[N][N];

        for(int i = 0; i < N; i++){
            String input = scanner.nextLine();
            for(int j = 0; j < N; j++){
                board[i][j] = input.charAt(j);
            }
        }

        int answer = 0;
        char tmp;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i < N - 1) {
                    tmp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = tmp;
                    answer = Math.max(answer, check(board));
                    board[i + 1][j] = board[i][j];
                    board[i][j] = tmp;
                }
                if(j < N - 1) {
                    tmp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = tmp;
                    answer = Math.max(answer, check(board));
                    board[i][j + 1] = board[i][j];
                    board[i][j] = tmp;
                }
            }
        }
        System.out.println(answer);
    }

    private static int check(char[][] board) {
        int checkInt = 0;
        for(int i = 0; i < board.length; i++){
            int count = 1;
            for(int j = 0; j < board.length - 1; j++){
                if(board[i][j] == board[i][j + 1])
                    count++;
                else {
                    count = 1;
                }
                checkInt = Math.max(checkInt, count);
            }
            count = 1;
            for(int j = 0; j < board.length - 1; j++){
                if(board[j][i] == board[j + 1][i])
                    count++;
                else {
                    count = 1;
                }
                checkInt = Math.max(checkInt, count);
            }
        }
        return checkInt;
    }
}
