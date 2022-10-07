package algoithm_monday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day1007_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] number = new int[4];
        for (int i = 0; i < 4; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int tmp = number[0];
        for (int i = 0; i < 4; i++) {
            for (int j = i+1; j < 4; j++) {
                if(number[i] > number[j]) {
                    tmp = number[i];
                    number[i] = number[j];
                    number[j] = tmp;
                }
            }
        }

        int sum = number[3] - number[0] + (number[2] - number[1]);
        System.out.println(sum);
    }
}
