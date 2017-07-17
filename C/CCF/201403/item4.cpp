#include <iostream>
#include <cmath>

using namespace std;

struct Point {
	int x, y;
};
int n, m, k, r;
// 0~n-1是已经放置路由器的位置，n~n+m-1是可以放路由器的位置
Point points[200];
bool graphs[200][200];
int dp[2][200];

bool reachable(int x1, int y1, int x2, int y2) {
	long long d2 = pow(x1 - x2, 2) + pow(y1 - y2, 2);
	long long r2 = pow(r, 2);
	return d2 <= r2;
}

void init_graphs() {
	for (int i = 0; i < n + m; i++) 
		for (int j = 0; j < n + m; j++)
			if (i == j)
				graphs[i][j] = false;
			else if (reachable(points[i].x, points[i].y, points[j].x, points[j].y))
				graphs[i][j] = graphs[j][i] = true;
}

void traverse(int node) {
	for (int i = 0; i < n + m; i++) {
		if (graphs[node][i] && dp[0][node] + 1 < dp[0][i]) {
			if (i < n) {
				// 如果是第一类点
				dp[0][i] = dp[0][node] + 1;
				traverse(i);
			} else if (dp[1][node] < k){
				// 如果是第二类点
				dp[1][i] = dp[1][node] + 1;
				dp[0][i] = dp[0][node] + 1;
				traverse(i);
			}
		}
	}

}

int main(int argc, char const *argv[])
{
	cin >> n >> m >> k >> r;
	for (int i = 0; i < n + m; i++)
		cin >> points[i].x >> points[i].y;
	dp[0][0] = -1;
	for (int i = 1; i < 200; i++) {
		dp[0][i] = 200;
		dp[1][i] = 0;
	}
	init_graphs();
	traverse(0);

	cout << dp[0][1];
	return 0;
}