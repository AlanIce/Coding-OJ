#include <iostream>
#include <queue>

using namespace std;
struct Tree {
	int data;
	Tree *left, *right;
};
int N;
int A[1000], B[1000];  // 中序,前序
Tree *root;
queue<Tree *> q;
/*
5
1 2 4 3 5
4 2 1 3 5
*/
void create_tree(Tree *&node, int Al, int Ar, int Bl, int Br)
{
	if (Al > Ar) return;
	node = (Tree *)malloc(sizeof(Tree));
	int root_data = A[Al];
	node->data = root_data;
	node->left = NULL;
	node->right = NULL;
	if (Al == Ar) return;
	int mid = 0;
	//在中序序列中找到根节点位置
	for(int i = Bl; i <= Br; i++)
		if (root_data == B[i]) { mid = i; break; }
	int l_length = mid - Bl;
	create_tree(node->left , Al + 1, Al  + l_length, Bl, mid - 1);
	create_tree(node->right , Al  + l_length + 1, Ar, mid + 1, Br);
}

void display() {
	while (!q.empty()) {
		Tree *node = q.front();
		q.pop();
		cout << node->data << " ";
		if (node->left) q.push(node->left);
		if (node->right) q.push(node->right);
	}
}

int main()
{
	cin >> N;
	for(int i = 0; i < N; i++)	cin >> A[i];
	for(int i = 0; i < N; i++)	cin >> B[i];
	create_tree(root, 0, N - 1, 0, N - 1);
	q.push(root);
	display();
	return 0;
}
