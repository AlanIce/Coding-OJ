#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
	TreeNode* reConstructBinaryTree(vector<int> pre,vector<int> vin) {
		if (pre.size() == 0) return NULL;
		int root = pre[0];
		TreeNode *node = (TreeNode *)malloc(sizeof(TreeNode));
		node->val = root;
		int index = find(vin.begin(), vin.end(), root) - vin.begin();
		vector<int> pre_l(index), pre_r(pre.size() - 1 - index), vin_l(index), vin_r(pre.size() - 1 - index);
		copy(pre.begin() + 1, pre.begin() + index + 1, pre_l.begin());
		copy(pre.begin() + index + 1, pre.end(), pre_r.begin());
		copy(vin.begin(), vin.begin() + index, vin_l.begin());
		copy(vin.begin() + index + 1, vin.end(), vin_r.begin());
		node->left  = reConstructBinaryTree(pre_l, vin_l);
		node->right = reConstructBinaryTree(pre_r, vin_r);
		return node;
	}
};