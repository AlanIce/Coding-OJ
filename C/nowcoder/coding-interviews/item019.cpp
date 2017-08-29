#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	vector<int> printMatrix(vector<vector<int> > matrix) {
		vector<int> result;
		int rowNum = matrix.size();
		int colNum = matrix[0].size();
		int line[4]  = {0, colNum - 1, rowNum - 1, 0};
		int start[4] = {0, 1, colNum - 2, rowNum - 2};
		int end[4]   = {colNum - 1, rowNum - 1, 0, 1};

		while (true) {
			if (end[0] - start[0] < 0) break;
			for (int i = start[0]; i <= end[0]; i++)
				result.push_back(matrix[line[0]][i]);
			line[0]++;
			start[0]++;
			end[0]--;

			if (end[1] - start[1] < 0) break;
			for (int i = start[1]; i <= end[1]; i++)
				result.push_back(matrix[i][line[1]]);
			line[1]--;
			start[1]++;
			end[1]--;

			if (start[2] - end[2] < 0) break;
			for (int i = start[2]; i >= end[2]; i--)
				result.push_back(matrix[line[2]][i]);
			line[2]--;
			start[2]--;
			end[2]++;

			if (start[3] - end[3] < 0) break;
			for (int i = start[3]; i >= end[3]; i--)
				result.push_back(matrix[i][line[3]]);
			line[3]++;
			start[3]--;
			end[3]++;
		}
		return result;
	}
};