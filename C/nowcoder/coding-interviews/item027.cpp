#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	vector<string> Permutation(string str) {
		vector<string> result;
		if (str.empty()) return result;
		sort(str.begin(), str.end());
		while (true) {
			result.push_back(str);
			int i = str.length() - 1, j = str.length() - 1;
			while (i > 0 && str[i] <= str[i - 1]) i--;
			if (i == 0) break;
			while (str[i - 1] >= str[j]) j--;
			swap(str[i - 1], str[j]);
			reverse(str.begin() + i, str.end());
		}
		return result;
	}
};