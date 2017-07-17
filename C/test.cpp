#include <iostream>
#include <vector>

using namespace std;

void func1(int n, int m) {
	int i = 0;
	while(++i <= m * n) {
		int p = i;
		// cout << "debug : " << p << endl;
		while (p > n) {
			p = p - n + (p - n - 1)/(m - 1);
			// cout << "debug : " << p << endl;
		}
		cout << p << " ";
	}
}
void func2(int n, int m) {
	int result = 0;//n=1情况  
	for (int i = 2; i <= n; i++) {  
		result = (result + m) % i; 
		cout << result << " "; 
	}  

}
int main(int argc, char const *argv[])
{	
	int n, m;
	cin >> n >> m; //n总人数，m步长
	func1(n, m);
}