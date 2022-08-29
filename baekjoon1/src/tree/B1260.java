package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class B1260 {

    static int[][] nodes;
    static boolean[] marked;
    static int n,m,v;
    static LinkedList<Integer> q = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        nodes = new int[n+1][n+1];
        marked = new boolean[n + 1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a][b] = nodes[b][a] = 1;
        }

        dfs(v);
        System.out.println();
        marked = new boolean[n + 1];
        bfs(v);

    }
    public static void dfs(int start){
        marked[start] = true;
        System.out.print(start + " ");
        for (int i = 0; i <= n; i++) {
            if (nodes[start][i] == 1 && !marked[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        q.add(start);
        marked[start] = true;

        while (!q.isEmpty()) {
            start = q.poll();
            System.out.print(start + " ");

            for (int i = 1; i <= n; i++) {
                if (nodes[start][i] == 1 && !marked[i]) {
                    q.add(i);
                    marked[i] = true;
                }
            }
        }
    }
}
