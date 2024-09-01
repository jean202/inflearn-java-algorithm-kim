package section7;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversalBFS {

    Node root;

    private void bfs(Node root){
        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            System.out.print(level + " level : ");
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                Node current = queue.poll();
                System.out.print(current.data + " ");
                if (current.lt != null) {
                    queue.offer(current.lt);
                }
                if (current.rt != null) {
                    queue.offer(current.rt);
                }
            }
            level++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTreeTraversalBFS main = new BinaryTreeTraversalBFS();
        main.root = new Node(1);
        main.root.lt = new Node(2);
        main.root.rt = new Node(3);
        main.root.lt.lt = new Node(4);
        main.root.lt.rt = new Node(5);
        main.root.rt.lt = new Node(6);
        main.root.rt.rt = new Node(7);
        main.bfs(main.root);
    }
}
