#include <iostream>

using namespace std;

class Solution {
public:
	string ReverseSentence(string str) {
		string result = "", temp = "";
		for (int i = 0; i < str.length(); i++) {
			if (str[i] == ' ') {
				result = temp + " " + result;
				temp = "";
			} else 
				temp += str[i];
		}
		if (temp.length() > 0) result = temp + " " + result;
		return result;
	}
};