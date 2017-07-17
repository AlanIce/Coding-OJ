#include <iostream>
using namespace std;

struct Window {
	int no, x1, x2, y1, y2;
};

int N, M;
Window windows[10];

int main(int argc, char const *argv[])
{
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		cin >> windows[i].x1 >> windows[i].y1 >> windows[i].x2 >> windows[i].y2;
		windows[i].no = i + 1;
	}
	for (int i = 0; i < M; i++) {
		int x, y, j;
		cin >> x >> y;
		for (j = N - 1; j >= 0; j--) {
			Window window = windows[j];
			if (x >= window.x1 && x <= window.x2 && y >= window.y1 && y <= window.y2) {
				cout << window.no << endl;
				for (int k = j + 1; k < N; k++)
					windows[k - 1] = windows[k];
				windows[N - 1] = window;
				break;
			}
		}
		if (j == -1) cout << "IGNORED" << endl;
	}
	return 0;
}