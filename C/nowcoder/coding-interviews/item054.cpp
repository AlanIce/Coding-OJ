#include <iostream>
#include <queue>

using namespace std;

class Solution {
public:
  //Insert one char from stringstream
	void Insert(char ch) {
		 count[ch - '\0']++;
		 if (count[ch - '\0'] == 1)
		 	que.push(ch);
	}
  //return the first appearence once char in current stringstream
	char FirstAppearingOnce() {
		while (!que.empty() && count[que.front()] > 1) que.pop();
		return que.empty() ? '#' : que.front();
	}

private:
	queue<char> que;
	int count[128] = {};
};