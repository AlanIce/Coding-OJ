#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct Edge {
	int u, v, w;
};

int n, m, dp[100001];
Edge edges[200000];

void init() {
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		cin >> edges[i].u >> edges[i].v >> edges[i].w;
		if (edges[i].u == 1)
			dp[edges[i].v] = edges[i].w;
		else if (edges[i].v == 1)
			dp[edges[i].u] = edges[i].w;
	}
	dp[1] = 0;
	for (int i = 2; i <= n; i++)
		dp[i] = 1000000;
}

void modify(int u, int v, int w) {
	if (u > v) {
		int temp = u;
		u = v;
		v = temp;
	}
	int t = dp[u] >= w ? dp[u] : w;
	if (dp[v] >= t) dp[v] = t;
}

int main() {
	init();
	for (int i = 2; i <= n; i++)
		for (int j = 0; j < m; j++) {
			modify(edges[j].u, edges[j].v, edges[j].w);
		}
	cout << dp[n];
	return 0;
}
