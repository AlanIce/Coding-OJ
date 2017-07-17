#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[])
{
	int n, nums[500];
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> nums[i];
	sort(nums, nums + n);
	int i = 0, j = n - 1, count = 0;
	while (nums[i] < 0 && nums[j] > 0) {
		int t = nums[i] + nums[j];
		if (t == 0) 
			i++, j--, count++;
		else if (t > 0)
			j--;
		else
			i++;
	}
	cout << count;
	return 0;
}