package day0811;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B2869_1 {

	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		int a = s.nextInt();
//		int b = s.nextInt();
//		int v = s.nextInt();
//		
//		int day = (v-a)/(a-b) + 1;
//		if((v-a)%(a-b)!=0)
//			day++; 
//		System.out.println(day);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int day = (v-a)/(a-b) + 1;
			if((v-a)%(a-b)!=0)
				day++; 
			System.out.println(day);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
