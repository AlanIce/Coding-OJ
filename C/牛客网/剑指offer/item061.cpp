#include <iostream>
#include <cstring>
#include <stack>

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
	char* Serialize(TreeNode *root) {  
		string str = _Serialize(root);
		char* result = new char[str.length() + 1];
		strcpy(result, str.c_str());
		return result;
	}
	
	TreeNode* Deserialize(char *str) {
		cout << "in : " << string(str) << endl; 
		return _Deserialize(string(str));
	}

private:
	stack<TreeNode*> st;
	string _Serialize(TreeNode *root) {    
		string result;
		if (!root) return "#";
		if (root->left || root->right)
			return to_string(root->val) + "(" + Serialize(root->left) + "," + Serialize(root->right) + ")";
		return to_string(root->val);
	}
	
	TreeNode* _Deserialize(string s) {
		for (int i = 0; i < s.length(); i++) {
			if (s[i] == '#') {
				cout << "push : #" << endl;
				st.push(NULL);
				continue;
			}
			if (s[i] == ')') {
				TreeNode* right = st.top();
				st.pop();
				TreeNode* left = st.top();
				st.pop();
				TreeNode* root = st.top();
				root->left = left;
				root->right = right;
				continue;
			}
			if (s[i] == ',') continue;
			int num = 0;
			while (s[i] != '(' && s[i] != ',' && s[i] != ')' && i < s.length()) {
				num = num * 10 + s[i] - '0';
				i++;
			}
			cout << "push : " << num << endl;
			st.push(new TreeNode(num));
			if (s[i] == ')') i--;
		}
		return st.top();
	}
};