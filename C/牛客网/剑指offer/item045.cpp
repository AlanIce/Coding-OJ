#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	bool IsContinuous(vector<int> numbers) {
		if (numbers.size() != 5) return false;
		sort(numbers.begin(), numbers.end());
		int count = 0;
		for (int i = 0; i < numbers.size(); i++)
			if (numbers[i] == 0)
				count++;
		for (int i = count; i < numbers.size() - 1; i++)
			if (numbers[i] == numbers[i + 1])
				return false;
		return numbers[numbers.size() - 1] - numbers[count] < numbers.size();		
	}
};