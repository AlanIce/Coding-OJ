#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	bool Find(int target, vector<vector<int> > array) {
		int rowCount = array.size();
		int colCount = array[0].size();
		for (int i = rowCount - 1, j = 0; i >= 0 && j < colCount; ) {
			cout << array[i][j] << endl;
			if (array[i][j] == target) return true;
			else if (array[i][j] > target) i--;
			else j++;

		}
		return false;
	}
};