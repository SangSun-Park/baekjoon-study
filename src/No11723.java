import java.util.Scanner;

public class No11723 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = Integer.parseInt(scanner.nextLine());
        int bit = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            String[] input = scanner.nextLine().split(" ");
            if(input[0].equals("add")){
                bit |= (1 << Integer.parseInt(input[1]));
            }
            else if(input[0].equals("check")){
                sb.append((bit & (1 << Integer.parseInt(input[1]))) != 0 ? 1 : 0).append("\n");
            }
            else if(input[0].equals("remove")){
                bit &= ~ (1 << Integer.parseInt(input[1]));
            }
            else if(input[0].equals("toggle")){
                bit ^= (1 << Integer.parseInt(input[1]));
            }
            else if(input[0].equals("all")){
                bit = (1 << 21) - 1;
            }
            else if(input[0].equals("empty")){
                bit = 0;
            }
        }
        System.out.println(sb);
    }
}
