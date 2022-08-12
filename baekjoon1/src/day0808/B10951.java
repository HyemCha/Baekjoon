package day0808;

import java.util.Scanner;

public class B10951 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int num1 = s.nextInt();
			int num2 = s.nextInt();
			if((num1<0 || num2>10)||!(num2>=0 && num2<=10))
				break;
			System.out.println(num1 + num2);
		}
	}

}
