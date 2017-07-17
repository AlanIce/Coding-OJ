#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	int numberOfArithmeticSlices(vector<int>& A) {
		if (A.size() < 3) return 0;
		vector<int> diff;
		int count = 0, last, length = 0;
		for (int i = 0; i < A.size() - 1; i++)
			diff.push_back(A[i + 1] - A[i]);
		last = diff[0], length = 0;
		for (int i = 1; i <= diff.size(); i++) {
			if (i == diff.size() || diff[i] != last) {
				for (int j = 1; j <= length; j++)
					count += j;
				length = 0;
				last = diff[i];
			}
			else if (diff[i] == last) length++;
		}
		return count;
	}
};