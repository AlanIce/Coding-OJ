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
	ListNode* EntryNodeOfLoop(ListNode* pHead) {
		if (pHead == NULL || pHead->next == NULL) return NULL;
		ListNode *fast = pHead, *slow = pHead;
		while (true) {
			fast = fast->next->next;
			slow = slow->next;
			if (fast == slow) break;
		}
		fast = pHead;
		while (fast != slow) {
			fast = fast->next;
			slow = slow->next;
		}
		return fast;
	}
};