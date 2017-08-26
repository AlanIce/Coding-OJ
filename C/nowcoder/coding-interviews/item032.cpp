#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	static bool compare(int a, int b) {
		return to_string(a) + to_string(b) < to_string(b) + to_string(a);
	}

	string PrintMinNumber(vector<int> numbers) {
		sort(numbers.begin(), numbers.end(), compare);
		string result = "";
		for (int i = 0; i < numbers.size(); i++)
			result += to_string(numbers[i]);
		return result;
	}
};