import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class No15686 {

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int[][] map;
    static ArrayList<Node> chicken, home;
    static Stack<Node> select;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] st = scanner.nextLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        map = new int[n][n];
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        select = new Stack<>();

        for (int i = 0; i < n; i++){
            st = scanner.nextLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st[j]);

                if (map[i][j] == 1){
                    home.add(new Node(i,j));
                }
                else if(map[i][j] == 2){
                    chicken.add(new Node(i,j));
                }
            }
        }

        selected(0,0);

        System.out.println(min);
    }

    static void selected(int start, int count){
        if(count == m){
            cal();
            return;
        }

        for(int i = start; i < chicken.size(); i++){
            select.push(chicken.get(i));
            selected(i + 1, count + 1);
            select.pop();
        }
    }

    static void cal(){
        int sum = 0;
        for(Node node : home){
            int mind = Integer.MAX_VALUE;
            for (Node chick : select){
                int dist = Math.abs(node.x - chick.x) + Math.abs(node.y - chick.y);
                mind = Math.min(mind, dist);
            }

            sum += mind;
            if (sum > min){
                return;
            }
        }
        min = Math.min(sum, min);
    }

}
