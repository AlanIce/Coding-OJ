#include <iostream>

using namespace std;

class Solution {
public:
	int NumberOf1Between1AndN_Solution(int n) {
		int count = 0, k;
		for (int i = 1; k = n / i; i *= 10) {
			count += (k / 10) * i;
			if (k % 10 > 1) 
				count += i;
			else if (k % 10 == 1) 
				count += n - k * i + 1;
		}
		return count;
	}
};