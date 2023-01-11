package tree_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B4963 {
    static int w;
    static int h;
    static int[][] m;
    static boolean[][] check;
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};
    static int count;//섬의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                System.out.println(0);
            }
            //배열 초기화
            m = new int[h][w];
            check = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    m[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    //dfs 들어가면 count증가
                    if (m[i][j] == 1 && !check[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        check[x][y] = true;

        //8방향 확인
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            //범위 안에 있고 배열 값이 1이고 true 라면
            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if (m[nx][ny] == 1 && !check[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
