#include <iostream>

using namespace std;

class Solution {
public:
	int FirstNotRepeatingChar(string str) {
		if(str.length() == 0) return -1;
		int hash[256] = {};		
		for (int i = 0; i < str.length(); i++) 
			hash[str[i]]++;
		for (int i = 0; i < str.length(); i++)
			if(hash[str[i]] == 1)
				return i;
		return -1;
	}
};