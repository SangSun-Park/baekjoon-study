import java.util.*;

public class No1051 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int maxS = Math.min(N, M);

        int[][] numbers = new int[N][M];

        for (int i = 0; i < N; i++){
            input = scanner.nextLine().split("");
            for (int j = 0; j < M; j++){
                numbers[i][j] = Integer.parseInt((input[j]));
            }
        }

        int maxSize = 0;
        
        for(int k = maxS; k > 0; k--) {
            for (int i = 0; i < N - (k-1); i++) {
                for (int j = 0; j < M - (k-1); j++) {
                    if(numbers[i][j] != numbers[i][j+(k-1)])
                        continue;
                    if(numbers[i][j] != numbers[i+(k-1)][j])
                        continue;
                    if(numbers[i][j] != numbers[i+(k-1)][j+(k-1)])
                        continue;
                    maxSize = k*k;
                    break;
                }
                if (maxSize != 0)
                    break;
            }
            if (maxSize != 0)
                break;
        }

        System.out.println(maxSize);
    }
}
