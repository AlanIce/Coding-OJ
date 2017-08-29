#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	int MoreThanHalfNum_Solution(vector<int> numbers) {
		int count = 0;
		int result;
		for (int i = 0; i < numbers.size(); i++) {
			if (count == 0) {
				result = numbers[i];
				count = 1;
			} else 
				count += numbers[i] == result ? 1 : -1;
		}
		if (count == 0) return 0;
		count = 0;
		for (int i = 0; i < numbers.size(); i++)
			if (numbers[i] == result)
				count++;
		if (count > numbers.size() / 2) return result;
		return 0;
	}
};