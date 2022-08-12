package day0805;

import java.util.Scanner;

public class B1152 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str;
		str = s.nextLine();
		if(str==" " || str.charAt(0)==' ') {
			System.out.println(0);
		}else {
			String[] strArr = str.split(" ");
			System.out.println(strArr.length);
		}
	}
}
