#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int N, M, t, result = 0;
	cin >> N >> M;
	vector<int> A, B, C, D(M);
	for (int i = 0; i < N; i++) {
		cin >> t;
		A.push_back(t);
	}
	for (int i = 0; i < M; i++) {
		cin >> t;
		B.push_back(t);
	}
	for (int i = 0; i < M; i++) {
		cin >> t;
		C.push_back(t);
	}
	sort(A.begin(), A.end());
	for (int i = N - 1; i >= 0; i--) {
		int min = INT_MAX;
		bool found = false;
		int tag = -1;
		for (int j = 0; j < M; j++) {
			if (B[j] >= A[i] && D[j] == 0 && min > C[j]) {
				found = true;
				min = C[j];
				tag = j;
			}
		}
		if (!found) {
			cout << "No";
			return 0;
		}
		D[tag] = 1;
		result += min;
	}
	cout << result;
	return 0;
}
