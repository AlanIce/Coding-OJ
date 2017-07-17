#include <iostream>
#include <string>
#include <vector>

using namespace std;

char flag[26];			//参数类型，0表示没用到，1表示无参，2表示带参
string params[26];
vector<string> result;

vector<string> split(string s, string c) {
	vector<string> res;
	while (true) {
		int pos = s.find(c);
		if (pos == -1) {
			res.push_back(s);
			break;
		}
		res.push_back(s.substr(0, pos));
		s = s.substr(pos + 1, s.length());
	}
	return res;
}

bool vaild_param(string s) {
	for (int i = 0; i < s.length(); i++)
		if ((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= '0' && s[i] <= '9') || s[i] == '-');
		else return false;
		return true;
}

void reset_params() {
	for (int i = 0; i < 26; i++)
		params[i] = "";
}

int main(int argc, char const *argv[])
{
	string line;
	int N;
	cin >> line >> N;
	for (int i = 0; i < line.length(); i++)
		if (line[i] != ':')
			if (i + 1 < line.length() && line[i + 1] == ':')
				flag[line[i] - 'a'] = 2;
			else
				flag[line[i] - 'a'] = 1;
	cin.get();
	for (int i = 0; i < N; i++) {
		getline(cin, line);
		vector<string> temp = split(line, " ");
		reset_params();
		for (int i = 1; i < temp.size(); i++) {
			if (temp[i].length() == 2 && temp[i][0] == '-' && temp[i][1] >= 'a' && temp[i][1] <= 'z') {
				if (flag[temp[i][1] - 'a'] == 0) {
					break;
				} else if (flag[temp[i][1] - 'a'] == 1) {
					params[temp[i][1] - 'a'] = "+";
				} else {
					if (vaild_param(temp[i + 1])) {
						params[temp[i][1] - 'a'] = temp[i + 1];
						i++;
					} else {
						break;
					}
				}
			} else {
				break;
			}
		}
		result.push_back("");
		for (int j = 0; j < 26; j++) {
			char c = j + 'a';
			if (flag[j] == 1 && params[j] == "+")
				result[i] += (" -" + string(&c, 1));
			else if (flag[j] == 2 && params[j] != "") {
				result[i] += (" -" + string(&c, 1) + " " + params[j]);
			}
		}
	}
	for (int i = 0; i < N; i++)
		cout << "Case " << (i + 1) << ": " << result[i] << endl;
	return 0;
}