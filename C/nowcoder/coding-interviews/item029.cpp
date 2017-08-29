#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
	vector<int> GetLeastNumbers_Solution(vector<int> input, int k) {
		if (k == 0 || input.size() < k) return vector<int>();
		vector<int> heap(input.begin(), input.begin() + k);
		make_heap(heap.begin(), heap.end());
		for (int i = k; i < input.size(); i++) {
			if (input[i] < heap[0]) {
				pop_heap(heap.begin(), heap.end());
				heap.pop_back();
				heap.push_back(input[i]);
				push_heap(heap.begin(), heap.end());
			}
		}
		sort_heap(heap.begin(), heap.end());
		return heap;
	}
};