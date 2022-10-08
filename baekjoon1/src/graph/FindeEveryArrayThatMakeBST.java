package graph;

import java.util.ArrayList;
import java.util.LinkedList;

class Tree7{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    //객체에서만 접근할 수 있음
    Node root;

    Tree7(int size) {
        //root를 루트로 하는 이진검색트리 만들기
        root = makeBST(90, size - 1);
    }

    Node makeBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBST(start, mid - 1);
        node.right = makeBST(mid + 1, end);
        return node;
    }
}

//이진 검색트리를 만드는 모든 배열 찾기
public class FindeEveryArrayThatMakeBST {
    public static void main(String[] args) {
        Tree7 t = new Tree7(5);
        ArrayList<LinkedList<Integer>> result = allSequences(t.root);
        for (LinkedList<Integer> l : result) {
            for (int data : l) {
                System.out.print(data);
            }
            System.out.println();
        }
    }

    //트리를 담은 모든 배열을 가져오는 함수
    //시작 노드를 인자로 받고
    //결과값은 배열 안의 각 리스트를 링크드리스트로 만들어 반환
    static ArrayList<LinkedList<Integer>> allSequences(Tree7.Node node) {
        //결과 저장할 배열방 객체 생성
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        //노드가 null인 경우 빈 리스트 만들어 반환
        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }
        //앞쪽에 고정으로 들어갈 prefix. 가장 첫 prefix는 루트가 됨
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);

        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                           ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = new LinkedList<>();
            for (int data : prefix) {
                result.add(data);
            }
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
    }
}
