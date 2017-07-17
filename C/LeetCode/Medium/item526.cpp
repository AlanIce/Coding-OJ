#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	int countArrangement(int N) {
		for (int i = 0; i <= N; i++) vec.push_back(0);
		traverse(1, N);
		return count;
	}

private:
	int count = 0;
	vector<int> vec;
	void traverse(int n, const int N) {
		if (n == N + 1) { count++; return; }
		for (int i = 1; i <= N; i++) {
			if (vec[i] == 0 && (i % n == 0 || n % i == 0)) {
				vec[i] = n;
				traverse(n + 1, N);
				vec[i] = 0;
			}
		}
	}
};