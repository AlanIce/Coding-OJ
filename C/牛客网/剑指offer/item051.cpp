#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	vector<int> multiply(const vector<int>& A) {
		vector<int> B(A.size());
		B[0] = 1;
		for (int i = 1; i < A.size(); i++) B[i] = B[i - 1] * A[i - 1];
		int temp = A[A.size() - 1];
		for (int i = A.size() - 2; i >= 0; i--) {
			B[i] *= temp;
			temp *= A[i];
		}
		return B;
	}
};