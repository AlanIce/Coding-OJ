#include <iostream>

using namespace std;

class Solution {
public:
	int StrToInt(string str) {
		if (str.length() == 0) return 0;
		int result = 0;
		bool flag = true;
		if (str[0] == '+') ;
		else if (str[0] == '-') flag = false;
		else if (str[0] - '0' < 0 || str[0] - '0' > 9) return 0;
		else result = str[0] - '0';
		for (int i = 1; i < str.length(); i++) {
			int t = str[i] - '0';
			if (t < 0 || t > 9) return 0;
			result = result * 10 + t;
		}
		return flag ? result : -result;
	}
};