package hackerearth.circuits.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class PermutationsOfNumbers {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			int tot = Integer.parseInt(br.readLine());
			long result=0;
			long[] L = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			long[] R = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			long[] diff= new long[tot];
			for(int i=0;i<tot;i++)
			{
				long temp= (R[i]*(tot))-L[i];
				//System.out.print(temp+" ");
				result+=temp;
				diff[i]=L[i]-R[i];
				
			}
			//System.out.println();
			Arrays.sort(diff);
			//print(diff);
			//System.out.println();
			
			for(int i=1;i<=tot;i++)
			{
				//System.out.println(diff[i-1]+" "+(tot-i+1));
				long temp= (tot-i+1)*diff[i-1];
				//System.out.print(temp +" ");
				result+=temp;
			}
			//System.out.println();
			System.out.println(result);
			
		}

	}

	private static void print(long[] diff) {
		for (int i = 0; i < diff.length; i++) {
			System.out.print(diff[i]+" ");
		}
		System.out.println();
	}


}
