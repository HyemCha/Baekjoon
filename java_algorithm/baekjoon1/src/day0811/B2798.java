package day0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2798 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0, m = 0;
		int[] arr = null;
		StringTokenizer st = null;
		try {
			int i=0;
			while((br.readLine())!=null) {
				st = new StringTokenizer(br.readLine());
				if(i==0) {
					n = Integer.parseInt(st.nextToken());
					m = Integer.parseInt(st.nextToken());
					arr = new int[n];
					System.out.println("n:"+ n+"/m:"+m);
					i++;
					continue;
				}
				for(int k=0; k<n; k++) {
					arr[k] = Integer.parseInt(st.nextToken());
					System.out.println("arr[k] : "+arr[k]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("n : " + n + "m : " + m);
		for(int re:arr) {
			System.out.print(re + " ");
		}

	}

}
