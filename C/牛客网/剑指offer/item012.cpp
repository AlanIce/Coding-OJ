#include <iostream>

using namespace std;

class Solution {
public:
	double Power(double base, int exponent) {
		double result = 1.0;
		int e = abs(exponent);
		while (e) {
			if (e & 1) result *= base;
			base *= base;
			e >>= 1;
		}
		return exponent > 0 ? result : 1 / result;
	}
};