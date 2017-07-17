#include <iostream>

using namespace std;

class Solution {
public:
	bool duplicate(int numbers[], int length, int* duplication) {
		for (int i = 0; i < length; i++) {
			int t = numbers[i] % length;
			if (numbers[t] >= length) {
				*duplication = t;
				cout << t;
				return true;
			}
			numbers[t] += length;
		}
		return false;
	}
};