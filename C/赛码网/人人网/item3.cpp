#include <iostream>
#include <vector>

using namespace std;

int main()
{		
	int n;
	while (cin >> n) {
		int t, sum = 0, round = 0, result = 0;
		vector<int> vec;
		for (int i = 0; i < n; i++) {
			cin >> t;
			vec.push_back(t);
			sum += t;
		}
		if (sum % 2 != 0) {
			cout << 0 << endl;
			continue;
		}
		sum /= 2;
		for (int i = 0; i < n - 1; i++) {
			round += vec[i];
			if (round == sum) result++;
		}
		cout << result << endl;
	}

	return 0;
}