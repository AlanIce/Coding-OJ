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
	void Mirror(TreeNode *pRoot) {
		if (pRoot == NULL) return;
		TreeNode *temp = pRoot->left;
		pRoot->left = pRoot->right;
		pRoot->right= temp;
		Mirror(pRoot->left);
		Mirror(pRoot->right);
	}
};