package tree_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B26667 {
    static int n;
    static int[][] m;
    static int count; //단지 집의 수
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};

    static ArrayList<Integer> result;//단지 집의 수 저장

    static boolean[][] check; //방문 체크

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = new int[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = s.next();
            for (int j = 0; j < n; j++) {
                m[i][j] = input.charAt(j) - '0';
            }
        }

        //단지 집의 수
        count = 0;
        //단지 집의 수 결과
        result = new ArrayList<>();
        //지도 전체 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(m[i][j]==1 && !check[i][j]){
                    //맨 처음이므로 count 1증가
                    count = 1;
                    Search(i, j);
                    result.add(count);
                }
            }
        }
        //결과 출력
        Collections.sort(result);
        System.out.println(result.size());
        for (int r : result) {
            System.out.println(r);
        }
    }

    private static void Search(int x, int y) {
        check[x][y] = true;

        //4방향 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dirX[i];
            int ny = y + dirY[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (m[nx][ny] == 1 && !check[nx][ny]) {
                    Search(nx, ny);
                    count++;
                }
            }
        }
    }
}
