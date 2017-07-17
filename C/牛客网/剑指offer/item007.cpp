#include <iostream>

using namespace std;

class Solution {
public:
	int Fibonacci(int n) {
		if (n == 0) return 0;
		int a = 0, b = 1, t;
		for (int i = 1; i < n; i++) {
			t = a + b;
			a = b;
			b = t;
		}
		return b;
	}
};