#include <iostream>

using namespace std;

struct RandomListNode {
	int label;
	struct RandomListNode *next, *random;
	RandomListNode(int x) :
			label(x), next(NULL), random(NULL) {
	}
};

class Solution {
public:
	RandomListNode* Clone(RandomListNode* pHead) {
		if (!pHead) return NULL;
		RandomListNode* curr = pHead;
		while (curr) {
			RandomListNode* cloneNode = new RandomListNode(curr->label);
			cloneNode->next = curr->next;
			cloneNode->random = curr->random;
			curr->next = cloneNode;
			curr = cloneNode->next;
		}
		curr = pHead;
		while (curr) {
			RandomListNode* cloneNode = curr->next;
			cloneNode->random = curr->random;
			curr = cloneNode->next;
		}
		RandomListNode* pCloneHead = pHead->next;
		curr = pHead;
		while(curr->next){
			RandomListNode* next = curr->next;
			curr->next = next->next;
			curr = next;
		}
		return pCloneHead;
	}
};