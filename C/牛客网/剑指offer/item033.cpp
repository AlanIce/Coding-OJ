#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	int GetUglyNumber_Solution(int index) {
		if (index == 0 || index == 1) return index;
		vector<int>	vec(index);
		vec[0] = 1;
		int i = 1, t2 = 0, t3 = 0, t5 = 0;
		while (i < index) {
			vec[i++] = min(min(vec[t2] * 2, vec[t3] * 3), vec[t5] * 5);
			if (vec[i-1] == vec[t2] * 2) t2++;
			if (vec[i-1] == vec[t3] * 3) t3++;
			if (vec[i-1] == vec[t5] * 5) t5++;
		}
		return vec[index - 1];
	}
};