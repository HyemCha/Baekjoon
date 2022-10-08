package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1012 {
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};

    static int[][] field;
    static boolean[][] mark;
    private static int t;
    private static int m;
    private static int n;
    private static int k;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        while(t>0){
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            // field 배열 초기화
            field = new int[m][n];
            mark = new boolean[m][n];


            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(field[i][j] == 1 && !mark[i][j]){
                        DFS(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
            t--;
        }
    }

    private static void DFS(int y, int x) {
        mark[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[0];
            int nx = x + dx[0];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if (field[ny][nx] == 1 && mark[ny][nx]) {
                    DFS(ny, nx);
                }
            }
        }
    }
}
