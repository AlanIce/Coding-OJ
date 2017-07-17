#include <iostream>

using namespace std;

class Solution {
public:
	string LeftRotateString(string str, int n) {
		if (str.length() == 0) return "";
		n %= str.length();
		string s1(str.begin(), str.begin() + n);
		string s2(str.begin() + n, str.end());
		return s2 + s1;
	}
};
