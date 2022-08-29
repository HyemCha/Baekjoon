package tree;

import java.util.ArrayList;
import java.util.LinkedList;

class Graph1 {
    class Node {
        int data;
        boolean marked;
        LinkedList<Node> adjacent;

        Node(int data) {
            this.data = data;
            this.marked = false;
            this.adjacent = new LinkedList<>();
        }
    }

    Node[] nodes;

    Graph1(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void initMarks() {
        for (Node n : nodes) {
            n.marked = false;
        }
    }

    //false로 초기화해주는 함수
    boolean search(int i1, int i2) {
        return search(nodes[i1], nodes[i2]);
    }

    //배열방 번호로 호출하면 노드로 변환하는 함수
    boolean search(Node start, Node end) {
        //start와 end 노드를 받는 누 개의 노드 간에 경로가 존재하는지 확인하는 함수
        //모든 마킹 플래그를 false로 초기화
        initMarks();
        //queue로 사용할 링크드 리스트
        LinkedList<Node> q = new LinkedList<>();
        int a = 1 + 1;
        q.add(start);
        while (!q.isEmpty()) {
            //큐에서 노드를 하나 꺼내서 엔드 노드이면 트루 리턴
            Node root = q.removeFirst();
            if (root == end) {
                return true;
            }
            for (Node n : root.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    q.add(n);
                }
            }
        }
        return false;
    }
}

public class Graph_findPath {
    public static void main(String[] args) {

        Graph1 g = new Graph1(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);
        System.out.println(g.search(1, 8));
    }
}
