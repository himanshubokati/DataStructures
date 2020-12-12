package hackerearth.easy.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MaximumSubsequences {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		int ttt = 1;
		while (test-- > 0) {
			if (ttt == 25) {
				System.out.println();
			}
			ttt++;
			String[] vals = br.readLine().split(" ");
			int tot = Integer.parseInt(vals[0]);
			int k = Integer.parseInt(vals[1]);
			int token = tot - k;
			String str = br.readLine();

			HashMap<Character, Integer> dp = new HashMap<>();
			for (char ch : str.toCharArray()) {
				dp.put(ch, dp.getOrDefault(ch, 0) + 1);
			}

			HashMap<Integer, Character> map = new HashMap<>();
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			for (int i = 97; i <= 97 + 25; i++) {
				if (arr[i - 97] != 0 && dp.containsKey((char) i))
					map.put(arr[i - 97], (char) i);
			}
			Arrays.sort(arr);
			int temp = k;
			HashMap<Character, Integer> req = new HashMap<>();
			for (int j = 25; j >= 0; j--) {
				if (temp == 0)
					break;
				if (map.containsKey(arr[j])) {
					int avl = dp.get(map.get(arr[j]));
					int p = Math.min(temp, avl);
					req.put(map.get(arr[j]), p);
					temp -= p;
				}
			}

			Stack<Character> stack = new Stack<>();
			int i = 0;
			while (i < tot) {
				if (req.getOrDefault(str.charAt(i), -1) > 0) {
					if (stack.empty()) {
						stack.push(str.charAt(i));
						req.put(str.charAt(i), req.get(str.charAt(i)) - 1);
						dp.put(str.charAt(i), dp.get(str.charAt(i)) - 1);
					} else {
						if (stack.peek() < str.charAt(i)) {
							stack.push(str.charAt(i));
							req.put(str.charAt(i), req.get(str.charAt(i)) - 1);
							dp.put(str.charAt(i), dp.get(str.charAt(i)) - 1);
						} else {
							while (!stack.empty() && stack.peek() > str.charAt(i)
									&& dp.get(stack.peek()) > req.get(stack.peek())) {
								char ch = stack.pop();
								req.put(ch, req.get(ch) + 1);
							}
							stack.push(str.charAt(i));
							req.put(str.charAt(i), req.get(str.charAt(i)) - 1);
							dp.put(str.charAt(i), dp.get(str.charAt(i)) - 1);

						}
					}

				}
				i++;
			}
			for (int j = 0; j < stack.size(); j++) {
				System.out.print(stack.get(j));
			}
			System.out.println();
		}
	}

}
