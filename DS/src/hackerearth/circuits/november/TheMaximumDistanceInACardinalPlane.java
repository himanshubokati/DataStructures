package hackerearth.circuits.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheMaximumDistanceInACardinalPlane {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		long[] arr = new long[total];
		for (int i = 0; i < total; i++) {
			arr[i] = Math.abs( Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sum());
		}
		
		
		int s = (int) Math.ceil((Math.log(total) / Math.log(2)));
		int size = 2 * (int) Math.pow(2, s) - 1;
		long[][] segTree = new long[size][2];
		constructSegTree(arr, segTree, 0, total-1, 0);

		int Q = Integer.parseInt(br.readLine());
		while (Q-- > 0) {
			String data[] = br.readLine().split(" ");
			if(data[0].equals("+"))
			{
				int idx= Integer.parseInt(data[1])-1;
				long sum= Math.abs(Long.parseLong(data[2])+Long.parseLong(data[3]));
				updateSegTree(arr, segTree, idx, sum, 0, total-1, 0);
			}
			else
			{
				int low=Integer.parseInt(data[1])-1;
				int high =Integer.parseInt(data[2])-1;
				long k= Long.parseLong(data[3]);
				long[] res= rangeQuery(segTree, 0, total-1, low, high, 0,k);
				long Ai= (long) Math.pow(res[0]-k,2);
				long Aj= (long) Math.pow(res[1]-k,2);
				long ress = Math.max(Math.abs(Ai-Aj), Math.abs(Aj-Ai));
				System.out.println(ress);
			}
		}
	}

	private static void constructSegTree(long[] arr, long[][] segTree, int low, int high, int pos) {
		if (high == low) {
			segTree[pos][0] = arr[low];
			segTree[pos][1] = arr[low];
			return;
		}

		int mid = (low + high) / 2;
		constructSegTree(arr, segTree, low, mid, 2 * pos + 1);
		constructSegTree(arr, segTree, mid + 1, high, 2 * pos + 2);

		segTree[pos][0] = Math.min(segTree[2 * pos + 1][0], segTree[2 * pos + 2][0]);
		segTree[pos][1] = Math.max(segTree[2 * pos + 1][1], segTree[2 * pos + 2][1]);
	}

	private static long[] rangeQuery(long[][] segTree, int low, int high, int qlow, int qhigh, int pos,long k) {
		if (qlow <= low && high <= qhigh) {
			return segTree[pos];
		}
		if (qlow > high || qhigh < low) {
			long t[] = new long[2];
			t[0] = 0;
			t[1] = 0;
			return t;
		}
		int mid = (low + high) / 2;
		long[] left = rangeQuery(segTree, low, mid, qlow, qhigh, 2 * pos + 1,k);
		long[] right = rangeQuery(segTree, mid + 1, high, qlow, qhigh, 2 * pos + 2,k);

		long t[] = new long[2];
		t[0] = Math.pow(left[0]-k,2)<Math.pow(right[0]-k,2)?left[0]:right[0];
		t[1] = Math.pow(left[1]-k,2)>Math.pow(right[1]-k,2)?left[1]:right[1];
		return t;
	}

	private static void updateSegTree(long[] arr, long[][] segTree, int index, long value, int low, int high, int pos) {

		if (index < low || index > high) {
			return;
		}
		if (low == high) {
			long low1 = segTree[pos][0];
			long high1 = segTree[pos][1];
			if (value < low1) {
				segTree[pos][0] = value;
			}
			if (value > high1) {
				segTree[pos][0] = high1;
				segTree[pos][1] = value;
			}
			return;
		}
		int mid = (low + high) / 2;
		updateSegTree(arr, segTree, index, value, low, mid, 2 * pos + 1);
		updateSegTree(arr, segTree, index, value, mid + 1, high, 2 * pos + 2);
		segTree[pos][0] = Math.min(segTree[2 * pos + 1][0], segTree[2 * pos + 2][0]);
		segTree[pos][1] = Math.max(segTree[2 * pos + 1][1], segTree[2 * pos + 2][1]);

	}
}
