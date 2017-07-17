#include <iostream>

using namespace std;

class Solution {
public:
	int movingCount(int threshold, int rows, int cols) {
		bool** flag = new bool*[rows];
		for (int i = 0; i < rows; i++)
			flag[i] = new bool[cols];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				flag[i][j] = true;
		int count = 0;
		movingCount(count, flag, 0, 0, threshold, rows, cols);
        return count;
	}

private:
	int getSum(int num) {
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

	void movingCount(int &count, bool** flag, int x, int y, int threshold, int rows, int cols) {
		if (x < 0 || y < 0 || x >= rows || y >= cols || flag[x][y] == false) return;
		if (getSum(x) + getSum(y) > threshold) return;
		flag[x][y] = false;
		count++;
		movingCount(count, flag, x, y - 1, threshold, rows, cols);
		movingCount(count, flag, x, y + 1, threshold, rows, cols);
		movingCount(count, flag, x - 1, y, threshold, rows, cols);
		movingCount(count, flag, x + 1, y, threshold, rows, cols);
	}
};