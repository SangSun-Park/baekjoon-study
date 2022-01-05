import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No2331 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int p = scanner.nextInt();
        int max = (int) (Math.pow(9, p) * 4 + 1);
        boolean[] numbers = new boolean[max];
        List<Integer> answers = new ArrayList<>();
        int x = a;
        while (!numbers[x]){
            numbers[x] = true;
            answers.add(x);
            int tmp = x;
            x = 0;
            while (tmp != 0){
                x += Math.pow(tmp % 10, p);
                tmp /= 10;
            }
        }
        System.out.println(answers.indexOf(x));
    }
}
