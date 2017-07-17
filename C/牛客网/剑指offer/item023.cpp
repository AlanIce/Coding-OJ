#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	bool VerifySquenceOfBST(vector<int> sequence) {
		return sequence.size() == 0 ? false : _VerifySquenceOfBST(sequence);
	}

private:    
    bool _VerifySquenceOfBST(vector<int> sequence) {
		int length = sequence.size();
		if (length < 4) return true;
		int root_data = sequence[length - 1];
		int index;
		for (index = 0; index < length - 1 && sequence[index] < root_data; index++);
		for (int j = index + 1; j < length - 1; j++)
			if (sequence[j] < root_data)
				return false;
		vector<int> left = subVec(sequence, 0, index - 1);
		vector<int> right = subVec(sequence, index, length - 2);
		return _VerifySquenceOfBST(left) && _VerifySquenceOfBST(right);
	}

	vector<int> subVec(vector<int> vec, int start, int end) {
		if (end - start < 0) return vector<int>();
		vector<int> result(end + 1 - start);
		copy(vec.begin() + start, vec.begin() + end + 1, result.begin());
		return result;
	}
};