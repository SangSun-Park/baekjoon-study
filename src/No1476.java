import java.util.Scanner;

public class No1476 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int E = Integer.parseInt(input[0]) % 15;
        int S = Integer.parseInt(input[1]) % 28;
        int M = Integer.parseInt(input[2]) % 19;
        int answer = 1;
        while(true){
            if(E == (answer % 15) && S == (answer % 28) && M == (answer % 19))
                break;
            answer ++;
        }
        System.out.println(answer);
    }
}
