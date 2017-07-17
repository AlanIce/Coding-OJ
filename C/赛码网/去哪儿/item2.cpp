#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
	string s;
	while (cin >> s) {
		long long result = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s[i];
			result *= 26;
			result += c - 'a';
		}
		cout << result << endl;
	}
	return 0;
}