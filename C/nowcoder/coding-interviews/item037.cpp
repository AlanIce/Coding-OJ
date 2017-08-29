#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	int GetNumberOfK(vector<int> data, int k) {
		int low = 0, high = data.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (data[mid] < k) low = mid + 1;
			else high = mid - 1;
		}
		int first = low;
		low = 0, high = data.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (data[mid] > k) high = mid - 1;
			else low = mid + 1;
		}
		int last = high;
		return last -first + 1;		
	}
};