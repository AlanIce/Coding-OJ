#include <iostream>

using namespace std;

struct Task {
	int a, b, c;
};

struct Schedule {
	int x, y, z;
};

int n, MIN;
Task tasks[41];
Schedule schedules[41];

/*--------------------- 优雅解法 ---------------------*/ 

int getMax(Schedule s) {
	return max(max(s.x, s.y), s.z);
}

/*
 * type
 * 1 : CPU1
 * 2 : CPU2
 * 3 : CPU1 + GPU
 * 4 : CPU2 + GPU
 * 5 : CPU1 + CPU2 + GPU
 */
Schedule modifySchedule(Schedule s, int type, Task t) {
	Schedule result = s;
	switch (type) {
	case 1: result.x += t.a; break;
	case 2: result.y += t.a; break;
	case 3: result.x += t.c; result.z += t.c; break; 
	case 4: result.y += t.c; result.z += t.c; break; 
	case 5: result.x += t.b; result.y += t.b; result.z += t.b; break; 
	}
	return result;
}

void addTask(int no) {
	Schedule last = schedules[no - 1], pre, result;
	Task t = tasks[no];
	int m = 10000;
	for (int i = 1; i <= 5; i++) {
		pre = modifySchedule(last, i, t);
		if (getMax(pre) < m) {
			m = getMax(pre);
			result = pre;
		}
	}
	schedules[no] = result;
}

/*--------------------- 暴力解法 ---------------------*/ 
void traverse(int no) {
	for (int i = 1; i <= 5; i++) {
		schedules[no] = modifySchedule(schedules[no - 1], i, tasks[no]);
		int temp = getMax(schedules[no]);
		if (temp >= MIN) return;
		if (no < n) traverse(no + 1);
		else if (no == n && temp < MIN) MIN = temp;
	}
}

int main(int argc, char const *argv[])
{
	cin >> n;
	for (int i = 1; i <= n; i++) {
		int t;
		cin >> tasks[i].a >> tasks[i].b >> tasks[i].c >> t;
		if (t < tasks[i].b) tasks[i].b = t;
	}
	for (int i = 1; i <= n; i++) 
		addTask(i);
	MIN = getMax(schedules[n]);

	traverse(1);

	cout << MIN;
	return 0;
}