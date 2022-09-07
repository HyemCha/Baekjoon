package tree_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Graph3 {
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

    //Node root;
    Node[] nodes;

    Graph3(int num) {
        nodes = new Node[num + 1];
        for (int i = 0; i <= num; i++) {
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

    //개수 세는 함수
    int findVirus() {
        //Node root = nodes[1];
        int cnt = 0;
        LinkedList<Node> q = new LinkedList<>();
        nodes[1].marked = true;
        q.add(nodes[1]);
        while (!q.isEmpty()) {
            Node root = q.removeFirst();
            if (root == null) {
                return cnt = 0;
            }
            for (Node n : root.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    q.add(n);
                    cnt++;
                }
            }
        }
        return cnt;
    }

}

public class B2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Graph3 g = new Graph3(n);
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g.addEdge(a, b);
        }
        System.out.print(g.findVirus());
    }
}
