#include <iostream>
#include <cstring>

using namespace std;

class Solution {
public:
	char arr[10] = "+-n.ne+-n";
	int turn[10][9] = {
	   //+  -  n  .  n  e  +  -  n
		{1, 1, 1, 0, 0, 0, 0, 0, 0},    // # start
		{0, 0, 1, 1, 0, 0, 0, 0, 0},    // +
		{0, 0, 1, 1, 0, 0, 0, 0, 0},    // -
		{0, 0, 1, 1, 0, 1, 0, 0, 0},    // n
		{0, 0, 0, 0, 1, 0, 0, 0, 0},    // .
		{0, 0, 0, 0, 1, 1, 0, 0, 0},    // n
		{0, 0, 0, 0, 0, 0, 1, 1, 1},    // e
		{0, 0, 0, 0, 0, 0, 0, 0, 1},    // +
		{0, 0, 0, 0, 0, 0, 0, 0, 1},    // -
		{0, 0, 0, 0, 0, 0, 0, 0, 1}     // n
	};
	bool isNumeric(char* string) {
		int cur = 0;
		for(int j, i = 0; string[i]; i++) {
			for(j = 0; j < 9; j++) {
				if(turn[cur][j]) {
					if(('0' <= string[i] && string[i] <= '9' && arr[j] == 'n') ||
						(string[i] == 'E' && arr[j] == 'e')||
						string[i] == arr[j]) {
						cur = j + 1;
						break;
					}
				}
			}
			if(j == 9) return false;
		}
		if(cur == 3 || cur == 4 || cur == 5 || cur == 9)
		   return true;
		return false;
	}
};