#include <iostream>
#include <stack>
#include <vector>

using namespace std;

class Solution {
public:
	bool IsPopOrder(vector<int> pushV,vector<int> popV) {
		if (popV.empty() || pushV.empty()) return false;
		stack<int> st;
		int index1 = 0, index2 = 0;
		while (index1 < pushV.size()) {
			st.push(pushV[index1++]);
			while (st.empty() == false && st.top() == popV[index2]) {
				st.pop();
				index2++;
			}
		}
		return st.empty();           
	}
};