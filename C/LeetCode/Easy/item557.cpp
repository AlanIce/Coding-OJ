#include <iostream>
#include <algorithm>

using namespace std;

class Solution {
public:
	string reverseWords(string s) {
		string result, temp;
		for (int i = 0; i < s.length(); i++) {
			if (s[i] == ' ') {
				reverse(temp.begin(), temp.end());
				result += temp;
				if (temp != "") 
					result += " ";
				temp = "";
			} else if (i == s.length() - 1) {
				temp += s[i];			
				reverse(temp.begin(), temp.end());
				result += temp;
				temp = "";
			} else
				temp += s[i];
		}
		if (result[result.length() - 1] == ' ')
			return result.substr(0, result.length() - 1);
		return result;
	}
};