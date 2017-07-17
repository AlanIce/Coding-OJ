#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	void FindNumsAppearOnce(vector<int> data,int* num1,int *num2) {
		int num = 0;
		*num1 = 0, *num2 = 0;
		for (int i = 0; i < data.size(); i++) 
			num ^= data[i];
		num = num & (~num + 1);
		vector<int> data1, data2;
		for (int i = 0; i < data.size(); i++) 
			if (data[i] & num) *num1 ^= data[i];
			else *num2 ^= data[i];
	}
};