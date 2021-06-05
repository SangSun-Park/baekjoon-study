import java.util.*;

public class No1068 {

    static int n, delete;
    static int[] node;
    static int count;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        node = new int[n];
        int root = 0;
        for(int i = 0; i < n; i++){
            node[i] = scanner.nextInt();
            if(node[i] == -1)
                root = i;
        }
        delete = scanner.nextInt();
        
        deleteNode(delete);

        count = 0;
        visited = new boolean[n];

        countLeaf(root);

        System.out.println(count);
    }

    private static void deleteNode(int delete) {
        node[delete] = -2;
        for (int i = 0; i < n; i++){
            if(node[i] == delete)
                deleteNode(i);
        }
    }

    private static void countLeaf(int number){
        boolean leaf = true;
        visited[number] = true;
        if(node[number] != -2){
            for(int i = 0; i < n; i++){
                if(node[i] == number && visited[i] == false){
                    countLeaf(i);
                    leaf = false;
                }
            }
            if(leaf)
                count++;
        }
    }
}
