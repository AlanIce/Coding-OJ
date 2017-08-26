#include <iostream>

using namespace std;

class Solution {
public:
	int rectCover(int number) {
		if (number == 0) return 0;
		int a = 1, b = 1, t;
		for (int i = 1; i < number; i++) {
			t = a + b;
			a = b;
			b = t;
		}
		return b;
	}
};