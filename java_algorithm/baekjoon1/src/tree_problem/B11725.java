package tree_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//문제
//루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 
//각 노드의 부모를 구하는 프로그램을 작성하시오.
public class B11725 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer,Integer> nodes = new HashMap<>();
        StringTokenizer st;
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if(n1 == 1){
                nodes.put(n2, n1);
                continue;
            }else if(n2 == 1){
                nodes.put(n1, n2);
                continue;
            }
            if(nodes.get(n1) == null){
                nodes.put(n1, n2);
            }else{
                nodes.put(n2, n1);
            }
        }
        for(int i=2; i<=n; i++){
            System.out.println(nodes.get(i));
        }
    }
}
