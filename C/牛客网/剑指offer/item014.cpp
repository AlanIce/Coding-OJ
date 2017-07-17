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
	ListNode* FindKthToTail(ListNode* pListHead, unsigned int k) {
		ListNode *p = pListHead, *q = pListHead;
		for (int i = 0; i < k; i++) {
			if (q == NULL)
				return NULL;
			q = q->next;
		}
		while (q != NULL) {
			p = p->next;
			q = q->next;
		}
		return p;
	}
};