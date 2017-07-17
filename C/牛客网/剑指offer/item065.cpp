#include <iostream>
#include <cstring>

using namespace std;

class Solution {
public:
	bool hasPath(char* matrix, int rows, int cols, char* str) {
		bool* flag = new bool[rows * cols];
		for (int i = 0; i < rows * cols; i++) flag[i] = true;
		int length = strlen(str);
		for (int i = 0; i < rows * cols; i++) {
			if (hasPath(i, flag, matrix, cols, rows, str))
				return true;
		}
		return false;
	}

private:
	bool hasPath(int loc, bool* flag, char* matrix, int rows, int cols, char* str) {
		if (*str == '\0') return true;
		if (loc < 0 || loc >= rows * cols) return false;
		bool result = false;
		if (*(matrix + loc) == *str && flag[loc]) {
			flag[loc] = false;
			result = hasPath(loc - rows, flag, matrix, rows, cols, str + 1) || hasPath(loc + rows, flag, matrix, rows, cols, str + 1)
				  || hasPath(loc - 1, flag, matrix, rows, cols, str + 1) || hasPath(loc + 1, flag, matrix, rows, cols, str + 1);
			flag[loc] = true;
		}
		return result;
	}
};