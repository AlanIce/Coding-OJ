#include <iostream>
#include <stack>

using namespace std;

class Solution {
public:
	void push(int value) {
		if (st.empty()) {
			st.push(0);
			_min = value;
			return;
		}
		st.push(value - _min);
		if (value < _min)
			_min = value;
	}
	void pop() {		
		long long t = st.top();
		st.pop();
		_min = t < 0 ? _min - t : _min;
	}
	int top() {
		long long t = st.top();
		return t < 0 ? _min : _min + t;
	}
	int min() {
		return _min;
	}

private:
	stack<long long> st;
	long long _min;
};