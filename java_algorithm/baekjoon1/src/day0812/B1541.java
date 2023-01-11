package day0812;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B1541 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		StringBuffer sb = new StringBuffer();
		sb.append(s.nextLine());
		
		//정규표현식을 이용해 split
		String[] numList = sb.toString().split("\\+|-");
		
		//numList의 요소들을 정수로 변환해서 배열에 넣기
		int[] num = new int[numList.length];
		
		for(int i=0; i<numList.length; i++) {
			num[i] = Integer.parseInt(numList[i]);
		}
		
		//sum은 합을 저장하는 변수
		int sum=num[0];
		
		//기호 저장
		List<String> operatorList = new ArrayList<>();

		//+를 -로 바꿀 때 사용
		boolean swc = false;
		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i)=='-') {
				operatorList.add("-");
				swc = !swc;
			}
			//-뒤에 있는 +를 -로 바꿈
			if(sb.charAt(i)=='+'&&swc==true) {
				operatorList.add("-");
				sb.setCharAt(i, '-');
			}
			if(sb.charAt(i)=='+')
				operatorList.add("+");
		}
		for(int i=0; i<operatorList.size(); i++) {
			if(operatorList.get(i)=="-")
				sum -= num[i+1];
			else
				sum += num[i+1];
		}
		System.out.println(sum);
		
	}

}
