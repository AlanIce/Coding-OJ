#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	vector<int> FindNumbersWithSum(vector<int> array, int sum) {
		int i = 0, j = array.size() - 1;
		vector<int> result;
		while (i <= j) {
			if (array[i] + array[j] == sum) {
				result.push_back(array[i]);
				result.push_back(array[j]);
				break;
			} else if (array[i] + array[j] > sum) j--;
			else if (array[i] + array[j] < sum) i++;
		}
		return result;	
	}
};