package graph;

import java.util.HashMap;

class Tree6 {
    static class Node {
        int data;
        Node left;
        Node right;
        Node parent;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;
    HashMap<Integer, Node> rootMap;

    Tree6(int size) {
        rootMap = new HashMap<>();
        root = makeBST(0, size - 1, null);
    }

    Node makeBST(int start, int end, Node parent) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBST(start, mid - 1, node);
        node.right = makeBST(mid + 1, end, node);
        node.parent = parent;
        rootMap.put(mid, node);
        return node;
    }

    //값으로 노드를 가져오는 함수
    Node getNode(int data) {
        return rootMap.get(data);
    }

    class Result {
        Node node; //노드를 저장할 주소
        boolean isAncestor; //찾았는지 여부를 저장

        Result(Node n, boolean isAnc) {
            node = n;
            isAncestor = isAnc;
        }
    }


/*    //#3
    //인자로 받은 노드가 부모의 서브트리인지 확인하는 함수
    boolean covers(Node root, Node node) {
        //해당 자손이 없으면 false
        if (root == null) {
            return false;
        }
        //있으면 true
        if (root == node) {
            return true;
        }
        //해당 노드의 왼쪽 오른쪽 자식 노드 검사
        return covers(root.left, node) || covers(root.right, node);
    }*/

    Node commonAncestor(int d1, int d2) {
        Node p = getNode(d1);
        Node q = getNode(d2);
        /*//#4
        return commonAncestor(root, p, q);*/
        Result r = commonAncestor(root, p, q);
        if (r.isAncestor) {
            return r.node;
        }
        return null;
/*
        //Solution #3
        //p와 q가 트리 안에 존재하지 않으면 null 반환
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        }
        //재귀함수 호출
        return ancestorHelper(root, p, q);
*/
    }

    //재귀호출할 함수
    Result commonAncestor(Node root, Node p, Node q) {
        //트리의 잎파리 노드까지 왔으면 null 반환하면서 재귀호출 돌려보냄
        if (root == null) {
            /*//#4
            return null;*/
            return new Result(null, false);
        }
        //p랑 q랑 root랑 다 같으면
        if (root == p && root == q) {
            /*//#4
            return root; */
            return new Result(root, false);
        }
        /*//#4
        Node x = commonAncestor(root.left, p, q);*/
        Result rx = commonAncestor(root.left, p, q);
        //오른쪽을 검사하기 전에, 노드를 받았는데 p도 q도 아닌데 null도 아니다
        //공통 분모를 찾았으므로 뒤에는 볼 것도 없이 해당 노드 반환
        /*//#4
        if (x != null && x != p && x != q) {
            return x;
        }*/
        if (rx.isAncestor) {
            return rx;
        }
        /*//#4
        Node y = commonAncestor(root.right, p, q);
        if (y != null && y != p && y != q) {
            return y;
        }*/
        Result ry = commonAncestor(root.right, p, q);
        if (ry.isAncestor) {
            return ry;
        }

        //공통 분모를 찾은 순간
        /*//#4
        if (x != null && y != null) {
            return root;
        } else if (root == p || root == q) {
            return root;
        } else{
            return x == null ? y : x;
        }*/
        if (rx.node != null && ry.node != null) {
            return new Result(root, true);
        } else if (root == p || root == q) {
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }
    }

/*
    //Solution #3
    Node ancestorHelper(Node root, Node p, Node q) {
        //root 가 널이면 노드 반환
        if (root == null || root == p || root == q) {
            return root;
        }
        boolean pIsOnLeft = covers(root.left, p);
        boolean qIsOnLeft = covers(root.left, q);
        //p와 q가 갈라지는 지점이 최초 조상
        if (pIsOnLeft != qIsOnLeft) {
            return root;
        }
        Node childSide = pIsOnLeft? root.left : root.right;
        return ancestorHelper(childSide, p, q);

    }
*/

/*
    //Solution #2. 형제 찾기
    Node commonAncestor(int d1, int d2) {
        Node p = getNode(d1);
        Node q = getNode(d2);
        if (!covers(root, p) || !covers(root, p)) {
            //루트에서 p와 q의 존재 여부를 확인
            //시작 노드 밑에 없으면 null
            return null;
        } else if (covers(p, q)) {
            //p가 q의 부모 노드면 p 반환
            return p;
        } else if (covers(q, p)) {
            //q가 p의 부모 노드면 q에서 만나므로 q를 반환
            return q;
        }
        //그 이외에는 형제 노드 가져옴
        //부모의 왼쪽이면 오른쪽 자식을, 오른이면 왼 자식을 가져옴
        //형제 노드와 부모 노드 가져오기
        Node sibling = getSibling(p);
        Node parent = p.parent;
        //레벨을 한 칸씩 올라가면서 두번째  노드가 형제의 하위트리에 속해있는지 알아옴
        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    private Node getSibling(Node node) {
        if (node == null || node.parent == null) {
            return null;
        }
        Node parent = node.parent;
        //현재 내가 부모의 왼자식이면 오 자식 반환, 아니면 왼 자식 반환
        return parent.left == node ? parent.right : parent.left;
    }
*/

    //공통부모 찾는 메서드
/*    Node commonAncestor(int d1, int d2) {
        Node p = getNode(d1);
        Node q = getNode(d2);
        int diff = depth(p) - depth(q);
        Node first = diff >0? q:p;
        Node second = diff < 0 ? p : q;
        //goUpBy 메서드로 first와 second를 같은 위치로 맞춰줌
        second = goUpBy(second, Math.abs(diff));
        //둘 중 하나가 루트 지나치면 나오기
        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }
        //null인 경우 제외하고 두개 중 아무거나 하나 반환
        return first == null || second == null ? null : first;
    }

    private Node goUpBy(Node node, int diff) {
        //차이(diff)만큼 노드가 올라감
        while (diff > 0 && node != null){
            node = node.parent;
            diff--;
        }
        return node;
    }
    //노드부터 루트까지 올라가면서 길이 카운트
    private int depth(Node node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }*/
}

public class FirstParent {
    public static void main(String[] args) {
        Tree6 t = new Tree6(10);
        Tree6.Node fa = t.commonAncestor(6, 7);
        System.out.println("the first common ancestor is " + fa.data);
    }
}
