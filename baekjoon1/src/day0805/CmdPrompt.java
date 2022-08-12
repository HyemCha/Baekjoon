package day0805;

import java.util.Scanner;

public class CmdPrompt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		String[] stringArr = new String[input];
		for (int i=0; i<input; i++) {
			stringArr[i] = s.nextLine();
			String[] tmp = new String[input];
			tmp[0] = stringArr[i];
			
		}
		
	}

}
