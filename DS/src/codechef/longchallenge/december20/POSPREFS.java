package codechef.longchallenge.december20;

import java.util.*;
import java.io.*;

public class POSPREFS {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();

		while (test-- > 0) {

			int n = sc.nextInt();
			int k = sc.nextInt();

			int[] arr = new int[n+1];
			for (int i = 1; i <= n; i++) {
				if ((i % 2) != 0) {
					arr[i] = i;
				} else {
					arr[i] = -i;
				}
			}
			int totPos = (int) Math.ceil(n*1.0 / 2);

			if (totPos > k) {
				int j = n - 1;
				int temp = totPos - k;
				while (temp > 0) {
					if (arr[j] > 0) {
						arr[j] *= -1;
						temp--;
					}
					j--;
				}
			}
			if (totPos < k) {
				int j = n - 1;
				int temp = k - totPos;
				while (temp > 0) {
					if (arr[j] < 0) {
						arr[j] *= -1;
						temp--;
					}
					j--;
				}

			}

			for (int i = 1; i <= n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

}
