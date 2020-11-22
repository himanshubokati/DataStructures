package hackerearth.circuits.november;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumAndMaximumDifferences {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] maxArr = new int[num + 1];
		int[] minArr = new int[num + 1];

		if (num == 1) {
			System.out.println(-1);
			System.out.println(-1);
			return;
		}
		long min = num % 2 == 0 ? num : num + 1;
		long max = (num * (num - 1) / 2L) + (num / 2);

		System.out.println(min);
		getMin(minArr, num);
		System.out.println(max);
		getMax(maxArr, num);

	}

	private static void getMax(int[] arr, int num) {
		int n = num;
		for (int i = 1; i <= n; i++, n--) {
			arr[i] = n;
			arr[n] = i;
		}
		
		if (num % 2 != 0) {
			arr[(num) / 2+1]++;
			arr[(num) / 2 ]--;
		}
		for (int i = 1; i <= num; i++) {
			System.out.print(arr[i] + " ");

		}
		System.out.println();
	}

	private static void getMin(int[] arr, int num) {

		for (int i = 1; i < num; i += 2) {
			arr[i] = i + 1;
			arr[i + 1] = i;
		}
		if (num % 2 != 0) {
			arr[num]=num;
			arr[num/2]++;
			arr[num ]--;
		}
		for (int i = 1; i <= num; i++) {
			System.out.print(arr[i] + " ");

		}
		System.out.println();
	}

}
