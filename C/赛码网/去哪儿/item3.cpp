#include <iostream>
#include <vector>
#include <string>

using namespace std;
struct Edge {
	int u, v;
};
int A[1000];

vector<string> vec;
vector<Edge> edges;

void split(string s) {
	while (true) {
		int index = s.find(" ");
		if (index == -1) {
			vec.push_back(s);
			break;
		}
		vec.push_back(s.substr(0, index));
		s = s.substr(index + 1, s.length());
	}
}

void traverse() {
	bool flag = true;
	while (flag) {
		flag = false;
		for (int i = 0; i < edges.size(); i++) {
			int u = edges[i].u;
			int v = edges[i].v;
			int length = A[u] + 1;
			if (A[v] > length) {
				flag = true;
				A[v] = length;
			}
			length = A[v] + 1;
			if (A[u] > length) {
				flag = true;
				A[u] = length;
			}
		}
	}
	
}


int main()
{
	string s, target;
	cin >> s;
	vec.push_back(s);
	cin >> target;
	getline(cin, s);
	getline(cin, s);
	split(s);
	for (int i = 0; i < vec.size(); i++)
		for (int j = i + 1; j < vec.size(); j++) {
			int m = 0;
			for (int k = 0; k < vec[i].length(); k++)
				if (vec[i][k] != vec[j][k])
					m++;
			if (m == 1) {
				Edge e;
				e.u = i;
				e.v = j;
				edges.push_back(e);
			}
		}
	A[0] = 0;
	for (int i = 1; i < 1000; i++) 
		A[i] = 1000;

	traverse();
	for (int i = 1; i < vec.size(); i++)
		if (vec[i] == target)
			cout << endl << A[i];
}