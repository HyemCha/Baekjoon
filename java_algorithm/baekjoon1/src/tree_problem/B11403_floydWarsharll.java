package tree_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class B11403_floydWarsharll {

    static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        //결과 그래프 초기화
        d = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                d[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //k를 거쳐가는 노드
        for (int k = 1; k <= n; k++) {
            //i는 출발노드
            for (int i = 1; i <= n; i++) {
                //j = 도착노드
                for (int j = 1; j <= n; j++) {
                    if (d[i][j] == 1) {
                        continue;
                    }
                    if (d[i][k] == 1 && d[k][j] == 1) {
                        d[i][j] = 1;
                    } else{
                        d[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(d[i][j] +" ");
            }
            System.out.println();
        }
    }
}
