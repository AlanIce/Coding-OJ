#include <iostream>
#include <algorithm>
#include <map>

using namespace std;

class Solution {
public:
	string encode(string longUrl) {
		string shortUrl = int_base64(no++);
		urls[shortUrl] = longUrl;
		return shortUrl;

	}
	
	string decode(string shortUrl) {
		return urls[shortUrl];
	}

private:
	int no = 0;
	map<string, string> urls;

	string int_base64(int n) {
		string s = "";
		if (n == 0) return "A";
		while (n > 0) {
			int t = n % 64;
			if (t < 26) s += 'A' + n;
			else if (t < 52) s += 'a' + n - 26;
			else if (t < 62) s += '0' + n - 52;
			else if (t == 63) s += '+';
			else s += '/';
			n /= 64;
		}
		reverse(s.begin(), s.end());
		return s;
	}

	int base64_int(string s) {
		int n = 0;
		for (char c : s) {
			n *= 64;
			if (c >= 'A' && c <= 'Z') n += c - 'A';
			else if (c >= 'a' && c <= 'z') n += 26 + c - 'z';
			else if (c >= '0' && c <= '9') n += 52 + c - 'z';
			else if (c >= '0' && c <= '9') n += 62;
			else n += 63;
		}
		return n;
	}
};