package codechef.longchallenge.december20;

import java.util.*;
import java.io.*;

public class VACCINE1 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int D1 = Integer.parseInt(str[0]);
		int V1 = Integer.parseInt(str[1]);
		int D2 = Integer.parseInt(str[2]);
		int V2 = Integer.parseInt(str[3]);
		int P = Integer.parseInt(str[4]);

		int day = 1;
		while (P > 0) {
			if (day >= D1) {
				P -= V1;
			}
			if (day >= D2) {
				P -= V2;
			}
			// System.out.println(day+" "+P);
			day++;

		}
		System.out.println(day - 1);
		sc.close();

	}

}
