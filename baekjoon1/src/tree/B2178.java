package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyPair;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B2178 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] miro = new char[n][m];
        int[][] dist = new int[n][m];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        LinkedList<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                miro[i][j] = line.charAt(j);
                dist[i][j] = -1;
            }
        }

        q.offer(new Pair(0, 0));
        dist[0][0] = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];

                if (nX < 0 || nX >= n || nY < 0 || nY >= m) {
                    continue;
                }
                if (miro[nX][nY] == '0' || dist[nX][nY] != -1) {
                    continue;
                }
                q.offer(new Pair(nX, nY));
                dist[nX][nY] = dist[p.x][p.y] + 1;
            }
        }
        System.out.print(dist[n - 1][m - 1] + 1);
    }
    static class Pair{
        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
