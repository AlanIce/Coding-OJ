#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	vector<int> maxInWindows(const vector<int>& num, unsigned int size) {
		vector<int> result;
		if (size == 0 || num.size() < size) return result;
		int maxnum = INT_MIN;
		for (int i = 0; i < num.size() && i < size; i++)
			if (maxnum < num[i]) maxnum = num[i];
		result.push_back(maxnum);
		for (int i = size; i < num.size(); i++) {
			if (num[i] > maxnum) maxnum = num[i];
			else if (num[i - size] == maxnum) {
				maxnum = INT_MIN;
				for (int j = 0; j < size; j++)
					if (maxnum < num[i - j]) maxnum = num[i - j];
			}
			result.push_back(maxnum);
		}
		return result;
	}
};