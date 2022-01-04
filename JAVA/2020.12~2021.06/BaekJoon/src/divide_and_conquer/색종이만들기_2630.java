/* ���� �������� �ǹ�3
 * ������ ����� 2630��
 * 
 */
package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �����̸����_2630 {
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int map[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			String a[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(a[j]);
		}
		// �Է� �Ϸ�

		divide(map, n, 0, 0);

		System.out.println(white + "\n" + blue);
		br.close();
	}

	// x,y �� ������ǥ
	static void divide(int map[][], int n, int x, int y) {

		if (n == 1) {
			if (map[y][x] == 1)
				blue++;
			else if(map[y][x] == 0)
				white++;

			return;
		}

		int divide_n = n / 2;

		int flag = map[y][x];
		int flag2 = 0;

		// 1��° ��
		for (int i = x; i < x + divide_n; i++) {
			flag2 = 0;

			for (int j = y; j < y + divide_n; j++) {
				if (flag != map[j][i]) {
					divide(map, divide_n, x, y);
					flag2 = 1;
					break;
				}
			}
			if (flag2 == 1)
				break;
		}
		if (flag2 == 0) {
			if (flag == 1)
				blue++;
			else
				white++;
		}

		// 2���� ��
		flag = map[y][x + divide_n];
		flag2 = 0;
		for (int i = x + divide_n; i < x + divide_n * 2; i++) {
			flag2 = 0;

			for (int j = y; j < y + divide_n; j++) {
				if (flag != map[j][i]) {
					divide(map, divide_n, x + divide_n, y);
					flag2 = 1;
					break;
				}
			}
			if (flag2 == 1)
				break;
		}
		if (flag2 == 0) {
			if (flag == 1)
				blue++;
			else
				white++;
		}

		// 3���� ��
		flag = map[y + divide_n][x];
		flag2 = 0;
		
		for (int i = x; i < x + divide_n; i++) {
			flag2 = 0;

			for (int j = y + divide_n; j < y + divide_n * 2; j++) {
				if (flag != map[j][i]) {
					divide(map, divide_n, x, y + divide_n);
					flag2 = 1;
					break;
				}
			}
			if (flag2 == 1)
				break;
		}
		if (flag2 == 0) {
			if (flag == 1)
				blue++;
			else
				white++;
		}

		// 4���� ��
		flag = map[y + divide_n][x + divide_n];
		flag2 = 0;
		
		for (int i = x + divide_n; i < x + divide_n * 2; i++) {
			flag2 = 0;

			for (int j = y + divide_n; j < y + divide_n * 2; j++) {
				if (flag != map[j][i]) {
					divide(map, divide_n, x + divide_n, y + divide_n);
					flag2 = 1;
					break;
				}
			}
			if (flag2 == 1)
				break;
		}
		if (flag2 == 0) {
			if (flag == 1)
				blue++;
			else
				white++;
		}
	}
}
