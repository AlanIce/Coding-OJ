#include <iostream>
#include <algorithm>

using namespace std;

class Solution {
public:
	int findPairs(vector<int>& nums, int k) {
		int count = 0;
		sort(nums.begin(), nums.end());
		for (int i = 0; i < nums.size(); i++) {
			if (i > 0 && nums[i] == nums[i-1]) continue;
			for (int j = i + 1; j < nums.size(); j++) 
				if (nums[j] - nums[i] < k) continue;
				else if (nums[j] - nums[i] == k) { count++; break;}
				else break;
		}
		return count;
	}
};