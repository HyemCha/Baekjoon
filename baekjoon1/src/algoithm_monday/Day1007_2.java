package algoithm_monday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day1007_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String og = st.nextToken();

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            System.out.println(name);
            if(name.contains(og))
                cnt++;
        }

        System.out.println(cnt);

    }
}
