#include <iostream>

using namespace std;

int main()
{
	int M, N;
	cin >> M >> N;
    if (M % (N + 1) == 0) {        
		cout << "none";
        return 0;
    }
    if (M >= N)
		cout << M % (N + 1) << " ";
    else
        for (int i = M; i <= N; i++)
            cout << i << " ";
	return 0;
}
