#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
	string s, t;
	cin >> s;
 	int num = 1;
	char last = s[0];
	for (int i = 1; i <= s.size(); i++) {
		if (i == s.size() || s[i] != last) {
			t += to_string(num) + last;
			last = s[i];
			num = 1;
		} else {
			num++;
		} 
	}
	cout << t;
	return 0;
}