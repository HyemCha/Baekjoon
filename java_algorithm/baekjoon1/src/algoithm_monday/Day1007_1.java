package algoithm_monday;
import java.io.*;
import java.util.StringTokenizer;

public class Day1007_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int island = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int edges[] = new int[island];
        int sum = 1;
        for(int i=0; i<edges.length; i++){
            edges[i] =Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<edges.length; i++){
            sum *= edges[i];
        }
        System.out.println();
    }
}
