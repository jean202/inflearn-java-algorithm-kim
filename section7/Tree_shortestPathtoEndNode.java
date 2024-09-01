package section7;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_shortestPathtoEndNode {

    Node root;

    public int dfs(int level, Node root) {
        if (root.lt == null && root.rt == null) {
            return level;
        } else {
            return Math.min(dfs(level + 1, root.lt), dfs(level + 1, root.rt));
        }
    }

    public int bfs(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int level = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                if (cur.lt == null && cur.rt == null) {
                    return level;
                }
                if (cur.lt != null) {
                    Q.offer(cur.lt);
                }
                if (cur.rt != null) {
                    Q.offer(cur.rt);
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Tree_shortestPathtoEndNode main = new Tree_shortestPathtoEndNode();
        main.root = new Node(1);
        main.root.lt = new Node(2);
        main.root.rt = new Node(3);
        main.root.lt.lt = new Node(4);
        main.root.lt.rt = new Node(5);
        int answer = main.dfs(0, main.root);
        System.out.println(answer);
    }
}
