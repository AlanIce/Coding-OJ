#include <iostream>
#include <vector>

using namespace std;

struct ListNode {
	int val;
	struct ListNode *next;
	ListNode(int x) :
			val(x), next(NULL) {
	}
};

class Solution {
public:
	ListNode* FindFirstCommonNode(ListNode* pHead1, ListNode* pHead2) {
		int length1 = getLength(pHead1);
		int length2 = getLength(pHead2);
		if (length1 > length2)
			for (int i = 0; i < length1 - length2; i++)
				pHead1 = pHead1->next;
		else if (length1 < length2)
			for (int i = 0; i < length2 - length1; i++)
				pHead2 = pHead2->next;
		while (pHead1 && pHead2) {
			if (pHead1 == pHead2) return pHead1;
			pHead1 = pHead1->next;
			pHead2 = pHead2->next;
		}
		return NULL;
	}

private:
	int getLength(ListNode* root) {
		int count = 0;
		while (root) {
			count++;
			root = root->next;
		}
		return count;
	}
};