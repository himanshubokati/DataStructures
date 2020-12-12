package codechef.longchallenge.december20;

import java.util.*;
import java.io.*;

public class EVENPSUM {
	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long a = sc.nextLong();
			long b = sc.nextLong();

			long ev1 = a / 2;
			long odd1 = a % 2 == 0 ? ev1 : ev1 + 1;
			long ev2 = b / 2;
			long odd2 = b % 2 == 0 ? ev2 : ev2 + 1;

			System.out.println(ev2 * ev1 + odd2 * odd1);
		}
	}
}
