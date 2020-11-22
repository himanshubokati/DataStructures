package hackerearth.circuits.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InputExpectations {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long test = Long.parseLong(br.readLine());
		long n = test;
		String[] arr = br.readLine().split(" ");
		long total = 0;
		int i = 0;
		while (i < test) {
			// System.out.println(i);
			long val = Long.parseLong(arr[i]);
			n--;

			if ((i + val) >= test) {
				total += val - (test - i-1);
			}

			i = (int) (i + val + 1);
		}
		System.out.println(total + n);
	}
}
