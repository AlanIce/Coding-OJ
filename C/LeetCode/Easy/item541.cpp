#include <iostream>

using namespace std;

class Solution {
public:
	string reverseStr(string s, int k) {
		for (int i = 0; i < s.length(); i += k * 2) {
			if (k > s.length() - i) k = s.length() - i;
			for (int j = 0; j < k / 2; j++) {
				char c = s[i + j];
				s[i + j] = s[i + k - 1 - j];
				s[i + k - 1 - j] = c;
			}

		}
		return s;
	}
};