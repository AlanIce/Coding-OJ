#include <iostream>

using namespace std;

class Solution {
public:
	void replaceSpace(char *str, int length) {
		if (str == NULL || length < 0) return;
		int numOfChar = 0, numOfSpace = 0;
		for (int i = 0; i < length && str[i] != '\0'; i++) {
			numOfChar++;
			if (str[i] == ' ')
				numOfSpace++;
		}
		int lastIndex = numOfChar + numOfSpace * 2;
		cout << lastIndex << endl;
		if (lastIndex > length) return;
		for (int i = numOfChar; i >= 0; i--) {
			if (str[i] == ' ') {
				str[lastIndex--] = '0';
				str[lastIndex--] = '2';
				str[lastIndex--] = '%';
			} else
				str[lastIndex--] = str[i];
		}
	}
};