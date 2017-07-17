class Solution {
public:
	vector<int> printListFromTailToHead(ListNode* head) {
		vector<int> result;
		while(head != NULL) {
			result.push_back(head->val);
			head = head->next;
		}
		reverse(result.begin(), result.end());
		return result;
	}
};