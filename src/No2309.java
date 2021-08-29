import java.util.*;

public class No2309 {
    static int[] talls = new int[9];
    static int[] answer = new int[7];
    static boolean end = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 9; i++){
            talls[i] = Integer.parseInt(scanner.nextLine());
        }
        Arrays.sort(talls);
        findAnswer(0, 0, 0);
        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }
    }

    private static void findAnswer(int start, int count, int total) {
        if(end) return;
        if(count == 7){
            if(total == 100)
                end = true;
            return;
        }

        if(start >= 9) return;
        if(total >= 100) return;
        answer[count] = talls[start];
        findAnswer(start + 1, count + 1, total + talls[start]);
        findAnswer(start + 1, count, total);
    }
}
