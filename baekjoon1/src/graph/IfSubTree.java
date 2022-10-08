package graph;

class Tree8 {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    Node root;

    Node makeBst(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBst(start, mid - 1);
        node.right = makeBst(mid + 1, end);
        return node;
    }

    //t2가 t1에 포함됐는지 확인하는 함수
    boolean containsTree(Node t1, Node t2) {
        //받은 인자들에 대한 기본 검사. 트리가 크므로 검사를 통해 미리 반환해주면 시간 절약됨
        if(t2 == null)
            return true;
        //재귀함수 호출
        return subTree(t1, t2);
    }

    //t1을 preorder 순회하며 t2의 루트 값과 같은 노드를 찾는 함수
    boolean subTree(Node t1, Node t2) {
        if (t1 == null) {
            return false;
        } //같은 노드를 만났다면(t1.data == t2.data) 해당 노드를 기준으로 두 개의 트리가 일치하는지 비교(matchTree(t1, t2))
        else if (t1.data == t2.data && matchTree(t1, t2)) {
            return true;
        }//위에서 같은 노드를 발견 못하거나 트리가 일치하지 않으면 재귀함수 호출
        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }

    //같은 노드를 기준으로 두 개의 트리가 일치하는지 확인하는 함수
    boolean matchTree(Node t1, Node t2) {
        //서로 다른 값이 있는 노드를 발견하지 못하고 똑같이 트리의 끝자락까지 옴
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else if (t1.data != t2.data) {
            return false;
        }
        //끝까지 도는 재귀
        else {
            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
        }
    }
}

public class IfSubTree {
    public static void main(String[] args) {
        Tree8 t1 = new Tree8();
        Tree8 t2 = new Tree8();
        //결과를 받아 저장하는 변수
        boolean result;
        t1.root = t1.makeBst(0, 9);
        t2.root = t2.makeBst(5,9);
        result = t1.containsTree(t1.root, t2.root);
        System.out.println(result);
    }
}
