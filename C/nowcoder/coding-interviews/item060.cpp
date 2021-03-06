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
	vector<vector<int> > Print(TreeNode* pRoot) {
		vector<vector<int> > result;
		if (!pRoot) return result;
		vector<TreeNode*> que;
		que.push_back(pRoot);
		while (!que.empty()) {
			vector<int> line;
			int length = que.size();
			for (int i = 0; i < length; i++) {
				TreeNode* node = que[i];
				line.push_back(node->val);
				if (node->left) que.push_back(node->left);
				if (node->right) que.push_back(node->right);
			}
			que.erase(que.begin(), que.begin() + length);
			result.push_back(line);
		}
		return result;
	}
};