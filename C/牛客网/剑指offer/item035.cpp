#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	int InversePairs(vector<int> data) {
		if(data.size() == 0) return 0;
		vector<int> copy(data);
		int count = InversePairsCore(data, copy, 0, data.size() - 1);//数值过大求余
		return count;
	}
private:
	int InversePairsCore(vector<int>& data, vector<int>& copy, int low, int high) {
		if(low >= high) return 0;
		int mid = (low+high) / 2;
		int leftCount = InversePairsCore(data, copy, low, mid);
		int rightCount = InversePairsCore(data, copy, mid + 1, high);
		int count = 0;
		int i = mid;
		int j = high;
		int locCopy = high;
		while(i >= low && j > mid) {
			if(data[i] > data[j]) {
				count += j - mid;
				count %= 1000000007;
				copy[locCopy--] = data[i--];
			}
			else
				copy[locCopy--] = data[j--];
		}
		for(; i >= low; i--) copy[locCopy--]=data[i];
		for(; j > mid; j--) copy[locCopy--]=data[j];
		for(int s = low; s <= high; s++) data[s] = copy[s];
		return (leftCount + rightCount + count) % 1000000007;
	}
};