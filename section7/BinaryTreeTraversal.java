package section7;

class Node {
    int data;
    Node lt;
    Node rt;

    public Node(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class BinaryTreeTraversal {

    Node root;

    private void dfs(Node root) {
        if (root == null) {
            return;
        } else {
            // 전위순회
            System.out.println(root.data + " ");
            dfs(root.lt);
            dfs(root.rt);

            // 중위순회
//            dfs(root.lt);
//            System.out.println(root.data + " ");
//            dfs(root.rt);

            // 후위순회
//            dfs(root.lt);
//            dfs(root.rt);
//            System.out.println(root.data + " ");
        }

    }

    public static void main(String[] args) {
        BinaryTreeTraversal main = new BinaryTreeTraversal();
        main.root = new Node(1);
        main.root.lt = new Node(2);
        main.root.rt = new Node(3);
        main.root.lt.lt = new Node(4);
        main.root.lt.rt = new Node(5);
        main.root.rt.lt = new Node(6);
        main.root.rt.rt = new Node(7);
        main.dfs(main.root);
    }

}
