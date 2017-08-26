#include <iostream>
#include <cmath>

using namespace std;

class Solution {
public:
	int jumpFloorII(int number) {
		if (number == 0) return 0;
		return pow(2, number - 1);
	}
};