#include <iostream>

using namespace std;

class Solution {
public:
	int Sum_Solution(int n) {
		int sum = n;
		sum && (sum += Sum_Solution(n - 1));
		return sum;
	}
};