import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No3190 {

    static class Apple{
        int x, y;
        public Apple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Dire{
        int x;
        char c;
        public Dire(int x, char c) {
            this.x = x;
            this.c = c;
        }
    }

    static int n, k, l;
    static List<Apple> appleList; 
    static List<Dire> direList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        k = Integer.parseInt(scanner.nextLine());
        int x, y, t;
        char c;
        String[] st;
        appleList = new ArrayList<>();

        for(int i = 0; i < k; i++){
            st = scanner.nextLine().split(" ");
            x = Integer.parseInt(st[0]);
            y = Integer.parseInt(st[1]);
            appleList.add(new Apple(x, y));
        }

        l = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < l; i++){
            st = scanner.nextLine().split(" ");
            t = Integer.parseInt(st[0]);
            c = st[1].charAt(0);
            direList.add(new Dire(t, c));
        }

    }
}
