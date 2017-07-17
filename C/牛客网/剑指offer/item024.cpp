#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
	TreeNode(int x) :
			val(x), left(NULL), right(NULL) {
	}
};

class Solution {
public:
	vector<vector<int> > FindPath(TreeNode* root,int expectNumber) {
		if (!root) return pathAll;
		path.push_back(root->val);
		expectNumber -= root->val;
		if (expectNumber == 0 && !root->left && !root->right)
			pathAll.push_back(vector<int>(path));
		FindPath(root->left, expectNumber);
		FindPath(root->right, expectNumber);
		path.pop_back();
		return pathAll;
	}

private:
	vector<vector<int> > pathAll;
	vector<int> path;
};