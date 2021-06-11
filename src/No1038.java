import java.util.*;

public class No1038 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            findNumbers(i, i-1, numbers);
        }

        if (numbers.size() <= n){
            System.out.println(-1);
            return;
        }
        Collections.sort(numbers);
        System.out.println(numbers.get(n));
    }

    private static void findNumbers(long num, int temp, ArrayList numbers){

        numbers.add(num);

        if (temp < 0){
            return;
        }

        for(int i = temp; i >= 0; i--){
            if(num % 10 != 0)
                findNumbers((num * 10) + i, i - 1, numbers);
        }
    }
}
