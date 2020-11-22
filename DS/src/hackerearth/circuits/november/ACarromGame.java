package hackerearth.circuits.november;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ACarromGame {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] black = new int[N];
		int[] white = new int[N];
		for (int i = 0; i < N; i++) {
			black[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			white[i] = sc.nextInt();
		}
		int red = sc.nextInt();
		sc.nextLine();
		int[] pl = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int Amax = pl[0], Bmax = pl[1], Ai = 0, Bi = 1;
		if (pl[0] < pl[2]) {
			Amax = pl[2];
			Ai = 2;
		}
		if (pl[1] < pl[3]) {
			Bmax = pl[3];
			Bi = 3;
		}

		Arrays.sort(black);
		Arrays.sort(white);
		int idBlack = 0, idWhilte = 0;
		int turn = 0;
		while (true) {
			if (Ai == turn) {
				if (idBlack < N && Amax >= black[idBlack]) {
					Amax += black[idBlack];
					idBlack++;

				} else {
					Amax++;
				}
				pl[turn] = Amax;
			}

			if (Bi == turn) {
				if (idWhilte < N && Bmax >= white[idWhilte]) {
					Bmax += black[idWhilte];
					idWhilte++;

				} else {
					Bmax++;
				}
				pl[turn] = Bmax;
			}
			if (turn != Ai && turn != Bi) {
				pl[turn]++;

			}
			turn = (turn + 1) % 4;
			if ((pl[turn] >= red && idWhilte >= N && (turn == 1 || turn == 3))
					|| (pl[turn] >= red && idBlack >= N && (turn == 2 || turn == 0))) {
				break;
			}
		}

		System.out.println((turn == 0 || turn == 2) ? "A-C" : "B-D");

	}

}
