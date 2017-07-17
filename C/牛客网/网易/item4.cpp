#include <iostream>
#include <iomanip>

using namespace std;

int main(int argc, char const *argv[])
{
	int n;
	cin >> n;
	double E = 0.0;
	for (int i = 1; i <= n; i++)
		E += ((double)1 / i);
	cout << setiosflags(ios::fixed) << setprecision(4) << E;
	return 0;
}