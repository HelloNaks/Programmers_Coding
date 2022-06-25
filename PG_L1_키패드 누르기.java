class Solution {
		public String solution(int[] numbers, String hand) {
			String answer = "";
			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, 1, 0, -1 };

			String[][] phone = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" }, { "*", "0", "#" } };
			Finger lfinger = new Finger(3, 0);
			Finger rfinger = new Finger(3, 2);

			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] % 3 == 1) {
					if (numbers[i] / 3 == 0) { // 1일 때
						lfinger = new Finger(0, 0);
						answer += "L";
					} else if (numbers[i] / 3 == 1) { // 4일 때
						lfinger = new Finger(1, 0);
						answer += "L";
					} else if (numbers[i] / 3 == 2) { // 7일 때
						lfinger = new Finger(2, 0);
						answer += "L";
					}
				} else if (numbers[i] % 3 == 2) { // 2, 5, 8일 때
					int r, c = 1;
					if (numbers[i] / 3 == 0) { // 2일 때
						r = 0;
					} else if (numbers[i] / 3 == 1) { // 5일 때
						r = 1;
					} else { // 8일 때
						r = 2;
					}

					int left = Math.abs(lfinger.r - r) + Math.abs(lfinger.c - c);
					int right = Math.abs(rfinger.r - r) + Math.abs(rfinger.c - c);
					if (left > right) {
						rfinger = new Finger(r, c);
						answer += "R";
					} else if (left < right) {
						lfinger = new Finger(r, c);
						answer += "L";
					} else {
						if (hand.equals("right")) {

							rfinger = new Finger(r, c);
							answer += "R";
						} else {
							lfinger = new Finger(r, c);
							answer += "L";
						}
					}
				} else {

					if (numbers[i] / 3 == 0) { // 0일 때

						int r = 3;
						int c = 1;

						int left = Math.abs(lfinger.r - r) + Math.abs(lfinger.c - c);
						int right = Math.abs(rfinger.r - r) + Math.abs(rfinger.c - c);

						if (left > right) {
							rfinger = new Finger(r, c);
							answer += "R";
						} else if (left < right) {
							lfinger = new Finger(r, c);
							answer += "L";
						} else {
							if (hand.equals("right")) {
								rfinger = new Finger(r, c);
								answer += "R";
							} else {
								lfinger = new Finger(r, c);
								answer += "L";
							}
						}
					} else if (numbers[i] / 3 == 1) { // 3일 때
						rfinger = new Finger(0, 2);
						answer += "R";
					} else if (numbers[i] / 3 == 2) { // 6일 때
						rfinger = new Finger(1, 2);
						answer += "R";
					} else if (numbers[i] / 3 == 3) { // 9일 때
						rfinger = new Finger(2, 2);
						answer += "R";
					}
				}
			}

			return answer;
		}

		public class Finger {
			int r;
			int c;

			public Finger(int r, int c) {
				this.r = r;
				this.c = c;
			}
		}
	}
