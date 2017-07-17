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
	TreeNode* Convert(TreeNode* pRootOfTree) {
		if (!pRootOfTree || (!pRootOfTree->left && !pRootOfTree->right)) return pRootOfTree;
		TreeNode* left = Convert(pRootOfTree->left);
		TreeNode* right = Convert(pRootOfTree->right);
		if (left) {
			while (left->right) left = left->right;
			left->right = pRootOfTree;
		}
		if (right) {
			right->left = pRootOfTree;            
		}
		pRootOfTree->right = right;		
		pRootOfTree->left = left;
		while (pRootOfTree->left) pRootOfTree = pRootOfTree->left;
		return pRootOfTree;
	}
};