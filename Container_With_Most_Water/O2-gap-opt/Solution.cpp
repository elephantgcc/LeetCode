#include <time.h>
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int maxArea(vector<int> &height) {
        if (height.size() == 0 || height.size() == 1) {
			return 0;
	}
	int max = 0;
	for (int i = 0; i < height.size(); ++i) {
		int gap = 1;
		if (height[i] > 0) {
			gap = max / (height[i]);
		}
		for (int j = i + gap; j < height.size(); ++j) {
			int area = (height[i] < height[j] ? height[i] : height[j]) * (j - i);
			max = max > area ? max : area;
		}
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
	cout << t1 << endl;
	cout << s.maxArea(vec) << endl;
	time_t t2 = clock();
	cout << t2 << endl;
	cout << (t2 - t1) / 1000 << endl;
}
