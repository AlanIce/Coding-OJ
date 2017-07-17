#include <iostream>

using namespace std;

class Solution {
public:
	int Add(int num1, int num2) {
		while (true) {
			num1 = num1 ^ num2;
			num2 = ((num1 ^ num2) & num2) << 1;
			if (num2 == 0) break;
		}
		return num1;
	}
};