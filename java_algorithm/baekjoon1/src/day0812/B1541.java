package day0812;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B1541 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		StringBuffer sb = new StringBuffer();
		sb.append(s.nextLine());
		
		//����ǥ������ �̿��� split
		String[] numList = sb.toString().split("\\+|-");
		
		//numList�� ��ҵ��� ������ ��ȯ�ؼ� �迭�� �ֱ�
		int[] num = new int[numList.length];
		
		for(int i=0; i<numList.length; i++) {
			num[i] = Integer.parseInt(numList[i]);
		}
		
		//sum�� ���� �����ϴ� ����
		int sum=num[0];
		
		//��ȣ ����
		List<String> operatorList = new ArrayList<>();

		//+�� -�� �ٲ� �� ���
		boolean swc = false;
		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i)=='-') {
				operatorList.add("-");
				swc = !swc;
			}
			//-�ڿ� �ִ� +�� -�� �ٲ�
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
