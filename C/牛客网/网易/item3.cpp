#include <iostream>
#include <string>
#include <queue>
#include <vector>

using namespace std;
struct humanbox {
	int hx,hy,bx,by;
	humanbox(int x, int y, int bbx, int bby):hx(x), hy(y), bx(bbx), by(bby){};
};

int main() {
	int n,m;
	cin >> n >> m;   
	vector<vector<int>> map(n,vector<int>(m,0));
	int hx,hy,bx,by,ex,ey;
	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < m; j++) {
			map[i][j] = str[j];
			if(str[j]=='X') {
				hx = i;
				hy = j;
			} else if(str[j] == '*') {
				bx = i;
				by = j;
			} else if(str[j] == '@') {
				ex = i;
				ey = j;
			}
		}
	}
	int stepx[4] = {0, 0, 1, -1};
	int stepy[4] = {1, -1, 0, 0};
	int count[10][10][10][10] = {0};
	queue<humanbox> que;
	que.push(humanbox(hx, hy, bx, by));
	count[hx][hy][bx][by]=1;
	while(!que.empty()) {
		humanbox top_que = que.front();
		que.pop();
		if (top_que.bx == ex && top_que.by == ey) {
			cout << (count[top_que.hx][top_que.hy][top_que.bx][top_que.by]) - 1 << endl;
			return 0;
		}
		for (int i = 0; i < 4; i++) {
			int hnx = top_que.hx + stepx[i];
			int hny = top_que.hy + stepy[i];
			if (hnx<0 || hny<0 || hnx>=n || hny>=m || map[hnx][hny]=='#') continue;
			if (hnx==top_que.bx && hny==top_que.by) {
				int bnx = top_que.bx + stepx[i];
				int bny = top_que.by + stepy[i];
				if (bnx<0 || bny<0 || bnx>=n || bny>=m || map[bnx][bny]=='#') continue;
				if (count[hnx][hny][bnx][bny]) continue;
				count[hnx][hny][bnx][bny] = count[top_que.hx][top_que.hy][top_que.bx][top_que.by]+1;
				que.push(humanbox(hnx,hny,bnx,bny));
			} else {
				if(count[hnx][hny][top_que.bx][top_que.by])	continue;
				count[hnx][hny][top_que.bx][top_que.by] = count[top_que.hx][top_que.hy][top_que.bx][top_que.by]+1;
				que.push(humanbox(hnx,hny,top_que.bx,top_que.by));
			}
		}
	}
	cout << -1 << endl;
	return 0;

}