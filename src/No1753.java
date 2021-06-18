import java.util.*;

public class No1753 {

    static class Node implements Comparable<Node>{
        int end, weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return weight - o.weight;
        }
    }

    static int v, e, k;
    static int[] dist;
    static List<Node>[] list;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] st = scanner.nextLine().split(" ");
        v = Integer.parseInt(st[0]);
        e = Integer.parseInt(st[1]);
        k = Integer.parseInt(scanner.nextLine());
        list = new ArrayList[v+1];
        dist = new int[v+1];

        Arrays.fill(dist, -1);

        for(int i = 1; i <= v; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++){
            st = scanner.nextLine().split(" ");
            int start = Integer.parseInt(st[0]);
            int end = Integer.parseInt(st[1]);
            int weight = Integer.parseInt(st[2]);
            list[start].add(new Node(end, weight));
        }

        dijkstra(k);

        String answer = "";

        for(int i = 1; i <= v; i++){
            if(dist[i] == -1) answer += "INF\n";
            else answer += dist[i] + "\n";
        }

        System.out.println(answer);

    }

    public static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[v+1];
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int cur = curNode.end;

            if(visited[cur] == true) continue;
            visited[cur] = true;

            for(Node node : list[cur]){
                if(dist[node.end] > dist[cur] + node.weight || dist[node.end] == -1){
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
