package day0810;

import java.util.Scanner;

public class B1010 {

	public static double combi(double n, double m) {
		
		//ºÐ¸ð
		double mnm = 1;
		for(double i=m; i>=(m-n+1); i--) {
			mnm *= i;
		}
		
		//n!
		double nn = 1;
		for(double i=1; i<=n; i++) {
			nn *= i;
		}
		
		return mnm/nn;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		double[] a = new double[t];
		for(int i=0; i<t; i++) {
			double m = s.nextDouble();
			double n = s.nextDouble();
			a[i] = combi(m,n);
		}
		
		for(int i=0; i<t; i++) {
			System.out.printf("%.0f \n",a[i]);
		}
	}
}
