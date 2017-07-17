#include <iostream>
#include <stack>
#include <vector>

using namespace std;

class Solution {
public:
	ListNode* Merge(ListNode* pHead1, ListNode* pHead2) {
		ListNode *head = (ListNode *)malloc(sizeof(ListNode));
		ListNode *curr = head;
		while (pHead1 != NULL & pHead2 != NULL) {
			if (pHead1->val < pHead2->val) {
				curr->next = pHead1;
				pHead1=pHead1->next;
			} else {
				curr->next = pHead2;
				pHead2=pHead2->next;
			}
			curr = curr->next;
		}
		curr->next = pHead2 == NULL ? pHead1 : pHead2;
		return head->next;
	}
};