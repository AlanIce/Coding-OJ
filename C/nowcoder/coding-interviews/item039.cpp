#include <iostream>

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
	bool IsBalanced_Solution(TreeNode* pRoot) {
		int depth = 0;
		return IsBalanced_Solution(pRoot, depth);
	}

private:
	bool IsBalanced_Solution(TreeNode* pRoot, int &depth) {
		if (!pRoot) {
			depth = 0;
			return true;
		}
		int leftDepth, rightDepth;
		bool leftBalanced = IsBalanced_Solution(pRoot->left, leftDepth);
		bool rightBalanced = IsBalanced_Solution(pRoot->right, rightDepth);
		if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1)
			return false;
		depth = max(leftDepth, rightDepth) + 1;
		return leftBalanced && rightBalanced;
	}
};