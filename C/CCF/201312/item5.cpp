#include <iostream>

using namespace std;

struct Point {
	int x, y;
};

enum FORWORD {
	UP, DOWN, LEFT, RIGHT
};

Point S, T;
int R, C, result;
/*
 * flag 
 * 0 ： 没走过
 * 1 ： 走过
 * 2 ： 除了.可以达到
 */
char graphs[50][50], flag[50][50];
bool stuck = true;

void traverse(int x, int y, int round);

void init() {
	cin >> R >> C;
	for (int i = 0; i < R; i++)
		for (int j = 0; j < C; j++)
			cin >> graphs[i][j];

	for (int i = 0; i < R; i++)
		for (int j = 0; j < C; j++)
			if (graphs[i][j] == 'S') {
				S.x = i;
				S.y = j;
			} else if (graphs[i][j] == 'T') {
				T.x = i;
				T.y = j;
			}
}

void display() {
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++)
			cout << graphs[i][j];
		cout << endl;
	}
}

/*
 * 返回true表示可以移动
 * 返回false表示不能移动
 */
bool move(int forward, int x, int y, int round) {
	if (round == 1) {
		switch (forward) {
		case UP:
			if ((x - 1) < 0  || graphs[x - 1][y] == '#' || flag[x - 1][y] == 1)
				return false;
			break;
		case DOWN:
			if ((x + 1) >= R || graphs[x + 1][y] == '#' || flag[x + 1][y] == 1)				
				return false;
			break;
		case LEFT:
			if ((y - 1) <  0 || graphs[x][y - 1] == '#' || flag[x][y - 1] == 1)
				return false;
			break;
		case RIGHT:
			if ((y + 1) >= C || graphs[x][y + 1] == '#' || flag[x][y + 1] == 1)
				return false;
			break;
		}
	} else {
		switch (forward) {
		case UP:
			if ((x - 1) < 0  || flag[x - 1][y] != 1 || graphs[x - 1][y] == '-')
				return false;
			break;
		case DOWN:
			if ((x + 1) >= R || flag[x + 1][y] != 1 || graphs[x + 1][y] == '-' || graphs[x + 1][y] == '.')				
				return false;
			break;
		case LEFT:
			if ((y - 1) <  0 || flag[x][y - 1] != 1 || graphs[x][y - 1] == '|' || graphs[x][y - 1] == '.')
				return false;
			break;
		case RIGHT:
			if ((y + 1) >= C || flag[x][y + 1] != 1 || graphs[x][y + 1] == '|' || graphs[x][y + 1] == '.')
				return false;
			break;
		}
	}
	return true;
}

void move_vertical(int x, int y, int round) {
	if (move(UP, x, y, round)) 
		traverse(x - 1, y, round);
	if (move(DOWN, x, y, round)) 
		traverse(x + 1, y, round);
}

void move_horizontal(int x, int y, int round) {
	if (move(LEFT, x, y, round)) 
		traverse(x, y - 1, round);
	if (move(RIGHT, x, y, round)) 
		traverse(x, y + 1, round);
}
/*
 * round 1 : 找出所有能到点
 * round 2 : 排除所有不可能的点
 * round 3 : 找出所有符合的点
 */
void traverse(int x, int y, int round) {
	// cout << x << "," << y << endl;
	if (round == 1) {
		flag[x][y] = 1;
		switch (graphs[x][y]) {
		case 'S':
			move_vertical(x, y, round);
			move_horizontal(x, y, round);			
			break;
		case 'T':
			stuck = false;
			move_vertical(x, y, round);
			move_horizontal(x, y, round);	
			break;
		case '+':			
			move_vertical(x, y, round);
			move_horizontal(x, y, round);	
			break;
		case '-':
			move_horizontal(x, y, round);	
			break;
		case '|':
			move_vertical(x, y, round);
			break;
		case '.':
			if (move(DOWN, x, y, round))
				traverse(x + 1, y, round);
			break;
		}
	} else {
		flag[x][y] = 2;
		// cout << x << "," << y << endl;
		move_vertical(x, y, round);
		move_horizontal(x, y, round);
	}
}

int main(int argc, char const *argv[])
{
	init();
	traverse(S.x, S.y, 1);
	if (stuck)
		cout << "I'm stuck!";
	else {
		traverse(T.x, T.y, 2);
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if ( flag[i][j] == 1 ) {
					// cout << "result : " << i << "," << j << endl;
					result++;
				}
		cout << result;
	}
	return 0;
}


/*

5 5
S---+
..##.
+--#.
+-##.
..##T


*/