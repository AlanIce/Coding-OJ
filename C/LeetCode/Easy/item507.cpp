#include <iostream>
#include <cmath>

using namespace std;

class Solution {
public:
	bool checkPerfectNumber(int num) {
		int result = 1;
		int s = (int) sqrt(num);
		if (s * s == num) result -= s;
		for (int i = 2; i <= s; i++)
			if (num % i == 0)
				result += i + num / i;
		return num == result;
	}
};