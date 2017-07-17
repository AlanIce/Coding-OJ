#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
 
class Solution {
public:
	int diameterOfBinaryTree(TreeNode* root) {
		calcLength(root);
		int MAX = 0;
		for (auto p : vec) 
			if (p.first + p.second > MAX)
				MAX = p.first + p.second;
		return MAX;
	}

private:
	vector< pair<int, int> > vec;
	int calcLength(TreeNode* root) {
		if (!root) return -1;
		int leftLength  = calcLength(root->left) + 1;
		int rightLength = calcLength(root->right) + 1;
		vec.push_back(make_pair(leftLength, rightLength));
		return leftLength > rightLength ? leftLength : rightLength;
	}
};