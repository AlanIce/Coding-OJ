#include <iostream>

using namespace std;

class Solution {
public:
	int LastRemaining_Solution(int n, int m) {
		if (n <= 0 || m <= 0) return -1;
		int result = 0;
		for (int i = 2; i <= n; i++) 
			result = (result + m) % i;
		return result + 1;
	}
};