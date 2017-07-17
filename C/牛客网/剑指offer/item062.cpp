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
	TreeNode* KthNode(TreeNode* pRoot, int k) {
		if (pRoot) {
			TreeNode* node;
			node = KthNode(pRoot->left, k);
			if (node) return node;
			if (++count == k) return pRoot;
			node = KthNode(pRoot->right, k);
			if (node) return node;
		}
		return NULL;
	}

	int count = 0;
};