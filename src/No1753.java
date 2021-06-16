import java.util.*;

public class No1753 {

    static int v, e, k;
    static int[] dist;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] st = scanner.nextLine().split(" ");
        v = Integer.parseInt(st[0]);
        e = Integer.parseInt(st[1]);
        k = scanner.nextInt();
        dist = new int[v+1];

        Arrays.fill(dist, -1);
        dist[k] = 0;
        

    }
}
