package algoithm_monday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day1021_2 {
    static String k1[] = {"1", ".", ",", "?", "!"};
    static String k2[] = {"2", "A", "B", "C"};
    static String k3[] = {"3", "D", "E", "F"};
    static String k4[] = {"4", "G", "H", "I"};
    static String k5[] = {"5", "J", "K", "L"};
    static String k6[] = {"6", "M", "N", "O"};
    static String k7[] = {"7", "P", "Q", "R", "S"};
    static String k8[] = {"8", "T", "U", "V"};
    static String k9[] = {"9", "W", "X", "Y", "Z"};
    static String s;
    static boolean marked[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] sarr = new String[n];
        marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            sarr[i] = st.nextToken();
            marked[i] = false;
        }
        dfs(sarr);
    }

    static int cnt = 0;
    public static void dfs(String[] sarr) {

    }

    public static void dfsR(String a) {
        switch (a) {
            case "1":
                cnt++;

        }
    }
}
