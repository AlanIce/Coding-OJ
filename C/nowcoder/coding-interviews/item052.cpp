#include <iostream>

using namespace std;

class Solution {
public:
	bool match(char* str, char* pattern) {
		if (str == NULL || pattern == NULL) return false;
		return matchCore(str, pattern);
	}

private:
	bool matchCore(char* str, char* pattern) {
		if (*str == '\0' && *pattern == '\0') return true;
		if (*str != '\0' && *pattern == '\0') return false;
		if (*(pattern + 1) == '*') {
			if (*pattern == *str || (*pattern == '.' && *str != '\0'))
				return matchCore(str + 1, pattern) || matchCore(str, pattern + 2);
			return matchCore(str, pattern + 2);
		}
		if (*pattern == *str || (*pattern == '.' && *str != '\0'))
			return matchCore(str + 1, pattern + 1);
		return false;
	}
};