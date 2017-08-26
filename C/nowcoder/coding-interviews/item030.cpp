#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	int FindGreatestSumOfSubArray(vector<int> array) {
		int max = array[0], last = array[0];
		for (int i = 1; i < array.size(); i++) {
			last = last < 0 ? array[i] : array[i] + last;
			max = max < last ? last : max;
		}
		return max;
	}
};