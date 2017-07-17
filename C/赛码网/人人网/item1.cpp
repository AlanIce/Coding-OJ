#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main()
{
	int n, array[50], length = 0, m = 100000;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> array[i];
		length += array[i];
		if (m > array[i])
			m = array[i];
	}

	bool finish = false;
	for (int i = m; i > 0; i--) {
		finish = true;
		for (int j = 0; j < n; j++)
			if (array[j] % i != 0) {
				finish = false;
				break;
			}
		if (finish) {
			cout << i;
			return 0;
		};
	}
	return 0;
}
