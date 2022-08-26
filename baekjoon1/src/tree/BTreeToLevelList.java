package tree;

import java.util.ArrayList;
import java.util.LinkedList;

class Tree2{
    class Node1{
        int data;
        Node1 left;
        Node1 right;
        Node1(int data){
            this.data = data;
        }
    }
    Node1 root;
    Tree2 (int size){
        root = makeBST(0, size - 1);
    }
    Node1 makeBST(int start, int end){
        if(start > end) return null;
        int mid = (start + end) / 2;
        Node1 node = new Node1(mid);
        node.left = makeBST(start, mid - 1);
        node.right = makeBST(mid + 1, end);
        return node;
    }

//Solution1. 재귀호출을 할 때 level을 함수의 인자로 받기
    ArrayList<LinkedList<Node1>> BSTtoList() {
        //재귀함수 호출 전에 함수를 호출해줄 초기값을 던져줄 함수
        ArrayList<LinkedList<Node1>> lists = new ArrayList<>();
        //배열방을 만들어 LinkedList를 담아 반환
        //시작할 때 만든 시작 노드와 결과를 담을 배열방 주소, 현재 레벨을 이용해 함수 호출
        BSTtoList(root, lists, 0);
        //재귀호출을 통해 획득한 결과 반환
        return lists;
    }
    //재귀함수 정의
    void BSTtoList(Node1 root, ArrayList<LinkedList<Node1>> lists, int level){
        //함수의 인자 : 노드, 리스트를 저장할 배열, 현재 레벨
        if(root == null) return;
        //해당 노드를 담을 리스트 선언
        LinkedList<Node1> list = null;
        //새로운 레벨의 노드를 처음 호출 할 때 해당 리스트가 배열방에 존재하지 않으므로
        //새로운 노드를 만들어서 배열방에 추가
        if(lists.size() == level){ //level==0일 때, 아직도 lists의 개수가 0개니? 그럼 하나 만들렴->lists의 size : 1, level : 0
            list = new LinkedList<>();
            lists.add(list);
        }//배열방에 해당 레벨의 리스트가 존재하면
        else{
            //해당 배열방에 노드를 추가해야 하므로 level번호로 기존에 있는 리스트의 시작주소를 획득
            list = lists.get(level);
        }
        //리스트에 노드 추가
        list.add(root);
        //자식 노드들로 함수 다시 호출
        BSTtoList(root.left, lists, level + 1);
        BSTtoList(root.right, lists, level + 1);
    }

//Solution2. BFS를 변형한 방법

    ArrayList<LinkedList<Node1>> BSTtoList2() {
        //결과값을 담을 배열방 선언
        ArrayList<LinkedList<Node1>> result = new ArrayList<>();
        //현재 레벨의 노드를 담을 LinkedList 생성
        LinkedList<Node1> current = new LinkedList<>();
        //초기값으로 root노드 담아줌
        if(root != null){
            current.add(root);
        }
        //현재 레벨에 노드가 있는 동안 반복
        while (current.size() > 0){
            //while문 이전에 실행한 결과를 올라와서 배열방에 담고 새로운 레벨 시작
            //처음에 시작시 루트 노드만 current에 담앗으므로 첫번째 레벨엔 root만 담김
            result.add(current);
            LinkedList<Node1> parents = current;
            //현재 레벨을 부모 레벨로 만들어주고 현재 레벨은 새로 시작
            current = new LinkedList<>();
            //부모 레벨의 노드들을 돌면서
            for(Node1 parent : parents){
                //왼쪽이나 오른쪽에 자식이 있으면 현재 레벨에 추가
                if(parent.left != null) current.add(parent.left);
                if(parent.right != null) current.add(parent.right);
            }
        }
        //현재 레벨에 담을 자식 노드가 남아있지 않을 때 결과 리스트를 담은 배열방 반환
        return result;
    }
    void printList(ArrayList<LinkedList<Node1>> arr){
        for(LinkedList<Node1> list : arr){
            for(Node1 node : list)
                System.out.print(node.data + " ");
            System.out.println();
        }
    }
}

//
public class BTreeToLevelList {
    public static void main(String[] args) {
        Tree2 t = new Tree2(10);
        t.printList(t.BSTtoList2());
    }
}
