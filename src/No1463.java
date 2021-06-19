import java.util.Scanner;

public class No1463 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;
        System.out.println(recur(n, answer));
    }

    static int recur(int n, int answer){
        if (n < 2){
            return answer;
        }

        return Math.min(recur(n / 2, answer + 1 + (n % 2)), recur(n / 3, answer + 1 + (n % 3)));
    }
}
