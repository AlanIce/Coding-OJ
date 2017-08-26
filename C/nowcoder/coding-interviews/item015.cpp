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
	ListNode* ReverseList(ListNode* pHead) {
		ListNode* h = (ListNode *)malloc(sizeof(ListNode));
        h->next = NULL;
        while(head != NULL) {
            ListNode *q = head->next;
            head->next = h->next;
            h->next = head;
            head = q;
        }
        return h->next;
	}
};