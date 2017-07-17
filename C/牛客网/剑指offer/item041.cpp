#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

class Solution {
public:
	vector<vector<int> > FindContinuousSequence(int sum) {
		vector<vector<int> > result;
		for (int i = ceil(sqrt(sum)); i > 0; i--) {
			if (i % 2 == 1 && sum % i == 0) {
				int mid = sum / i;
				vector<int> vec;
				for (int j = mid - i / 2; j <= mid + i / 2; j++)
					vec.push_back(j);
				result.push_back(vec);
			} else if (i % 2 == 0 && sum % i == i / 2) {
				int mid = sum / i;
				vector<int> vec;
				for (int j = mid - i / 2 + 1; j <= mid + i / 2; j++)
					vec.push_back(j);
				result.push_back(vec);
			}
		}
		return result;
	}
};