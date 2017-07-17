#include <iostream>

using namespace std;

int main()
{
	int n, m, i, t = 0;
	cin >> n >> m;
	for (i = 1; i <= n; i++) {
		t += i * 5;
		if (t > 240 - m) {
			cout << (i - 1);
			break;
		}
	}
	if (i == n + 1) cout << n;
	return 0;
}
