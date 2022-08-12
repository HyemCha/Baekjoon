package day0812;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B1541 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		StringBuffer sb = new StringBuffer();
		sb.append(s.nextLine());
		
		String[] numList = sb.toString().split("\\+|-");
		int[] num = new int[numList.length];
		
		for(int i=0; i<numList.length; i++) {
			num[i] = Integer.parseInt(numList[i]);
		}
			
		int sum=num[0];
		
		List<String> minusList = new ArrayList<>();

		boolean swc = false;
		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i)=='-') {
				minusList.add("-");
				swc = !swc;
			}
			if(sb.charAt(i)=='+'&&swc==true) {
				minusList.add("-");
				sb.setCharAt(i, '-');
			}
			if(sb.charAt(i)=='+')
				minusList.add("+");
		}
		for(int i=0; i<minusList.size(); i++) {
			if(minusList.get(i)=="-")
				sum -= num[i+1];
			else
				sum += num[i+1];
		}
		System.out.println(sum);
		
	}

}
