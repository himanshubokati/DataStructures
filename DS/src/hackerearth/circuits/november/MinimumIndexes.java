package hackerearth.circuits.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinimumIndexes {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] vals = br.readLine().split(" ");
			int tot = Integer.parseInt(vals[0]);
			int q = Integer.parseInt(vals[1]);
			int[] dp = new int[tot];
			String[] arr = br.readLine().split(" ");
			getData(arr, dp);

			while (q-- > 0) {
				boolean f = true;
				String ss = br.readLine();
				int num = Integer.parseInt(ss) - 1;
				int sum = getSum(arr[num]);
				long Ai= Long.parseLong(arr[num]);
				

				while (num < arr.length) {
					
					
					if (sum > dp[num] ) {
						long Aj= Long.parseLong(arr[num]);
						if(Ai<Aj){
						//System.out.println(dp[num]+" " +sum);
						System.out.println(num + 1);
						f = false;
						break;
					}}
					num++;
				}
				if (f) {
					System.out.println(-1);
				}

			}

		}

		private static void getData(String[] arr, int[] dp) {

			for (int i = 0; i < arr.length; i++) {
				int sum = getSum(arr[i]);
				dp[i] = sum;
			}

		}

		private static int getSum(String num) {
			return Arrays.stream(num.split("")).mapToInt(Integer::parseInt).sum();

		}

	}
