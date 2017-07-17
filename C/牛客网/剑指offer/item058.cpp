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
	bool isSymmetrical(TreeNode* pRoot)	{
		if (!pRoot) return true;
		return equal(pRoot->left, pRoot->right);
	}

private:
	bool equal(TreeNode* pRoot1, TreeNode* pRoot2) {
		if (!pRoot1 && !pRoot2) return true;
		if (!pRoot1 || !pRoot2) return false;
		if (pRoot1->val != pRoot2->val) return false;
		return equal(pRoot1->left, pRoot2->right) && equal(pRoot1->right, pRoot2->left);
	}
};