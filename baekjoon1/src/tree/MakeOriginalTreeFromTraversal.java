package tree;

class Treee {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;
    //포스트 오더나 프리오더의 배열방을 어디까지 읽었나 가리키는 인덱스
    static int pIndex = 0;

    public void buildTreeByInPre(int in[], int pre[]) {
        pIndex = 0;
        root = buildTreeByInPre(in, pre, 0, in.length - 1);
    }

    //재귀함수
    private Node buildTreeByInPre(int in[], int pre[], int start, int end) {
        if (start < end) { //서로 지나치면 재귀호출 종료
            return null;
        }
        Node node = new Node(pre[pIndex++]);
        if (start == end) {
            return node;
        }
        int mid = search(in, start, end, node.data);
        node.left = buildTreeByInPre(in, pre, start, mid - 1);
        node.right = buildTreeByInPre(in, pre, mid + 1, end);
        return node;
    }

    public void buildTreeByInPost(int in[], int post[]) {
        pIndex = post.length - 1;
        root = buildTreeByInPre(in, post, 0, in.length - 1);
    }

    private Node buildTreeByInPost(int in[], int post[], int start, int end) {
        if (start > end) {
            return null;
        }
        Node node = new Node(post[pIndex--]);
        if (start == end) {
            return node;
        }
        int mid = search(in, start, end, node.data);
        node.left = buildTreeByInPre(in, post, start, mid - 1);
        node.right = buildTreeByInPre(in, post, mid + 1, end);
        return node;
    }

    private int search(int[] arr, int start, int end, int value) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return i;
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.println(node.data + " ");
        printInorder(node.right);
    }
}

public class MakeOriginalTreeFromTraversal {
    public static void main(String[] args) {
        Treee t = new Treee();
        int[] pre = {4, 2, 1, 3, 6, 5, 7};
        int[] in = {1, 2, 3, 4, 5, 6, 7};
        int[] post = {1, 3, 2, 5, 7, 6, 4};
        t.buildTreeByInPre(in,pre);
        t.printInorder(t.root);
        System.out.println(" ");
        t.buildTreeByInPost(in,post);
        t.printInorder(t.root);
    }
}
