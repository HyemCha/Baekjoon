package tree;

class Tree5{
    class Node{
        int data;
        Node left;
        Node right;
        Node parent;
        Node(int data){
            this.data = data;
        }
    }

    Node root;
    Tree5(int size){
        root = makeBST(0, size-1, null);
    }
    Node makeBST(int start, int end, Node parent){
        if(start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBST(start, mid - 1, node);
        node.right = makeBST(mid + 1, end, node);
        node.parent = parent;
        return node;
    }
    void findNext(Node node){
        //오른쪽 노드가 없는 경우, 위에서 찾아야 함
        if(node.right == null){
            //부모노드와 함께 현재 노드를 넘겨야 함(그래야 어느쪽 자식이엇는지 확인할 수 있으므로)
            System.out.println(findAbove(node.parent, node).data + " is " + node.data + "'s next");
        }//오른쪽 자식이 있으면 아래로
        else{
            System.out.println(findBelow(node.right).data + " is " + node.data + "'s next");
        }
    }

    Node findAbove(Node root, Node child) {
        if(root == null) return null;
        if(root.left == child) return root;
        return findAbove(root.parent, root);
    }
    Node findBelow(Node root) {
        //돌다가 재귀호출을 멈추는 경우. 왼쪽에 더이상 자식이 없을 때 해당 노드가 다음 노드가 됨
        if(root.left == null) return root;
        return findBelow(root.left);
    }

}
public class FindNextNode {
    public static void main(String[] args) {
        Tree5 t = new Tree5(10);
        t.findNext(t.root.right);
    }
}
