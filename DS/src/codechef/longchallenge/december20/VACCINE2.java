package codechef.longchallenge.december20;

import java.util.*;
import java.io.*;

public class VACCINE2 {

	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int tot = sc.nextInt();
			int d = sc.nextInt();
			sc.nextLine();
			int risk = 0;
			for (int i = 0; i < tot; i++) {
				int curr = sc.nextInt();
				if (curr <= 9 || curr >= 80) {
					risk++;
				}
			}

			System.out.println((int) Math.ceil(risk * 1.0 / d) + (int) Math.ceil((tot - risk) * 1.0 / d));
		}
	}

}
