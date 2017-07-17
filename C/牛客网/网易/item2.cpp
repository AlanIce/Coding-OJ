#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
	int N, D, nums[100][100], MAX = 0, temp;
	cin >> N >> D;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			cin >> nums[i][j];

	// 水平 
	for (int i = 0; i < N; i++) {
		temp = 0;
		for (int k = 0; k < D; k++)
			temp += nums[i][k];
		if (temp > MAX) MAX = temp;
		for (int j = D; j < N; j++) {
			temp = temp + nums[i][j] - nums[i][j - D];
			if (temp > MAX) MAX = temp;
		}

	}

	// 垂直
	for (int j = 0; j < N; j++) {
		temp = 0;
		for (int k = 0; k < D; k++)
			temp += nums[k][j];
		if (temp > MAX) MAX = temp;
		for (int i = D; i < N; i++) {
			temp = temp + nums[i][j] - nums[i - D][j];
			if (temp > MAX) MAX = temp;
		}
	}

	// 左上-右下1
	for (int i = 0; i <= N - D; i++) {
		temp = 0;
		for (int k = 0; k < D; k++)
			temp += nums[i + k][k];
		if (temp > MAX) MAX = temp;
		for (int j = D; j < N - i; j++) {
			temp = temp + nums[i + j][j] - nums[i + j - D][j - D];
			if (temp > MAX) MAX = temp;
		}
	}

	// 左上-右下2
	for (int i = 0; i <= N - D; i++) {
		temp = 0;
		for (int k = 0; k < D; k++)
			temp += nums[k][i + k];
		if (temp > MAX) MAX = temp;
		for (int j = D; j < N - i; j++) {
			temp = temp + nums[j][i + j] - nums[j - D][i + j - D];
			if (temp > MAX) MAX = temp;
		}
	}

	// 左下-右上1
	for (int i = 0; i <= N - D; i++) {
		temp = 0;
		for (int k = 0; k < D; k++)
			temp += nums[N - 1 - i - k][k];
		if (temp > MAX) MAX = temp;
		for (int j = D; j < N - i; j++) {
			temp = temp + nums[N - 1 - i - j][j] - nums[N - 1 - i - j + D][j - D];
			if (temp > MAX) MAX = temp;
		}
	}

	// 左下-右上2
	for (int i = 0; i <= N - D; i++) {
		temp = 0;
		for (int k = 0; k < D; k++)
			temp += nums[k][N - 1 + i - k];
		if (temp > MAX) MAX = temp;
		for (int j = D; j < N - i; j++) {
			temp = temp + nums[j][N - 1 + i - j] - nums[j - D][N - 1 + i - j + D];
			if (temp > MAX) MAX = temp;
		}
	}

	cout << MAX;
	return 0;
}