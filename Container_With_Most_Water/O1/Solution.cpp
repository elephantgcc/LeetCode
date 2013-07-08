#include <iostream>
#include <vector>
#include <time.h>
using namespace std;

class Solution {
public:
	int maxArea(vector<int> &height) {
        	if (height.size() == 0 || height.size() == 1) {
			return 0;
		}
		int i = 0, j = height.size() - 1;
		int max = 0;
		while(i < j) {
			int area = 0;
			if (height[i] <= height[j]) {
				area = (height[i] < height[j] ? height[i] : height[j]) * (j - i);
				++i;
			} else {
				area = (height[i] < height[j] ? height[i] : height[j]) * (j - i);
				--j;
			}
			max = max > area ? max : area;
		}
		return max;
	}
};

int main() {
	Solution s;
	vector<int> vec;
	for (int i = 10000 - 1; i >= 1; --i) {
		vec.push_back(i);
	}
	time_t t1 = clock();
	cout << s.maxArea(vec) << endl;
	time_t t2 = clock();
	cout << (t2 - t1) << endl;
}
