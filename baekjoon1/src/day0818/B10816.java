package day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10816 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<m; i++) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(upperBound(arr, key) - lowBound(arr, key)).append(' ');
		}
		
		System.out.println(sb);
	}
//	[-10 -10 2 3 3 6 7 *10 10 10]
	private static int lowBound(int[] arr, int key) {
		int lo = 0; //
		int hi = arr.length;//11
		while(lo<hi) {
			int mid =(lo+hi)/2;//5 //2
			if(key<=arr[mid])
				hi = mid;//5
			else
				lo = mid + 1;
		}
		return lo;
	}

	private static int upperBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		
		while(lo<hi) {
			int mid = (lo + hi) / 2;
			
			if(key<arr[mid]) {
				hi = mid;
			}else
				lo = mid + 1;
		}
		return lo;
	}
	

}
