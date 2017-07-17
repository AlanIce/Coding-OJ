#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	vector<int> countBits(int num) {
		vector<int> result;
		result.push_back(0);
		for (int i = 1; i <= num; i <<= 1)
			for (int j = 0; j < i && i + j <= num; j++)
				result.push_back(1 + result[j]);
		return result;
	}
};