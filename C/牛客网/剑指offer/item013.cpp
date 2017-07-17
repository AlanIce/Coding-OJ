#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool isOk(int n){  return ((n & 1) == 1); }

class Solution{
public:
	void reOrderArray(vector<int> &array){
		stable_partition(array.begin(), array.end(), isOk);
	}
};