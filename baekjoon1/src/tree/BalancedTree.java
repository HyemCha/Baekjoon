package tree;

class Tree3{
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    Node root;
    Tree3(int size){
        //이진트리 만들기
        root = makeBST(0, size - 1);
        root.right.right.right.right = new Node(10);
    }
    Node makeBST(int start, int end){
        if(start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBST(start, mid - 1);
        node.right = makeBST(mid + 1, end);
        return node;
    }
    boolean isBalanced(Node root){
        //마지막 노드를 지났으면 더이상 진행을 하지 않고 true반환
        if(root == null) return true;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if(Math.abs(heightDiff) > 1)
            return false;
        else
            return isBalanced(root.left) && isBalanced(root.right);
    }
    //해당 노드를 루트로 서브트리의 가장 긴 줄기의 레벨을 알아오는 함수
    private int getHeight(Node root) {
        //node 주소를 받음
        //돌다가 트리의 마지막 노드를 지나면 -1을 받아 level 카운팅 번호에서 하나뺌
        if(root == null) return -1;
        //자식노드들을 반복적으로 호출하면서 둘 중 더 긴 줄기를 선택 후 1을 더해 반환
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    //길이를 재는 함수
    //반환값 : 레벨의 길이, 정수의 가장 작은 값(false의 의미로 사용)
    int checkHeight(Node root){
        if(root == null) return -1;
        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int rightHeight = checkHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int heightDiff = leftHeight - rightHeight;
        if(Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        }else{
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    boolean isBalanced2 (Node root){
        return checkHeight(root) != Integer.MIN_VALUE;
    }

//======================================================
    //객체에 저장
    class Level{
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }
    boolean isBalanced3(Node root){
        Level obj = new Level();
        //재귀함수 호출
        checkBalanced(root, obj, 0);
        if(Math.abs(obj.min - obj.max) > 1) return false;
        else return true;
    }
    //재귀적으로 호출되며 obj의 값을 업데이트하는 함수
    void checkBalanced(Node node, Level obj, int level){
        //맨 마지막 노드를 지남
        if(node == null){
            if(level < obj.min) obj.min = level;
            else if(level > obj.max) obj.max = level;
            return;
        }
        checkBalanced(node.left, obj, level +1);
        checkBalanced(node.right, obj, level +1);
    }
}
public class BalancedTree {
    public static void main(String[] args) {
        Tree3 t = new Tree3(10);
        System.out.println(t.isBalanced3(t.root));
    }

}
