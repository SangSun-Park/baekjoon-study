import java.util.*;

public class No1759 {

    static int L, C;
    static String[] alpha;
    static String[] vowel = {"a", "e", "i", "o", "u"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] st = scanner.nextLine().split(" ");
        L = Integer.parseInt(st[0]);
        C = Integer.parseInt(st[1]);
        alpha = scanner.nextLine().split(" ");
        Arrays.sort(alpha);

        makeAnswer("", 0, 0);

    }

    static void makeAnswer(String answer, int depth, int start){
        if (depth == L) {
            if (check(answer))
                System.out.println(answer);
            return;
        }

        for (int i = start; i < C; i++){
            answer += alpha[i];
            makeAnswer(answer, depth + 1, i + 1);
            answer = answer.substring(0, answer.length()-1);
        }
    }

    static boolean check(String answer){
        int count = 0;
        for (String v : vowel){
            if (answer.contains(v)){
                count++;
            }
        }
        return count != 0 && L - count >= 2;
    }
}
