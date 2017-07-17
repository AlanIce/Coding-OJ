#include <iostream>

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
	ListNode* deleteDuplication(ListNode* pHead) {
		if (pHead == NULL) return NULL;
		if (pHead->next == NULL) return pHead;
		ListNode *next = pHead->next;
		if (pHead->val == next->val) {
			while (next && pHead->val == next->val) next = next->next;
			return deleteDuplication(next);
		}
		pHead->next = deleteDuplication(next);
		return pHead;
	}
};