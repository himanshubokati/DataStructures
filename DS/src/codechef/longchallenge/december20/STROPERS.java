package codechef.longchallenge.december20;

import java.util.*;
import java.io.*;

public class STROPERS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		sc.nextLine();
		while (test-- > 0) {
			String str = sc.nextLine();
			HashSet<String> set = new HashSet<>();
			int i, j, n = str.length();
			for (i = 0; i < n; i++) {
				int cnt = 0, even = 0, odd = 0;
				for (j = i; j < n; j++) {
					if (str.charAt(j) == '1') {
						cnt++;
					} else {
						if (cnt % 2 != 0) {
							odd++;
						} else {
							even++;
						}
					}
					int len = j - i + 1;
					set.add(len + " " + even + " " + odd);
				}
				
			}
			System.out.println(set.size());
		}

	}

}
