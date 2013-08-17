#include <vector>
using namespace std;

class Solution {
public:
    void solve(vector<vector<char> > &board) {
		if (board.size() == 0) {
			return;
		}
		int M = board.size();
		int N = board[0].size();
		for (int j = 0; j < N; ++j) {
			dfs(board, 0, j);
			dfs(board, M - 1, j);
		}
		for (int i = 0; i < M; ++i) {
			dfs(board, i, 0);
			dfs(board, i, N - 1);
		}
		for (int i = 0; i < M; ++i) {
			for (int j = 0; j < N; ++j) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == '+') {
					board[i][j] = 'O';
				}
			}
		}
    }

	void dfs(vector<vector<char> > &board, int i, int j) {
		int M = board.size();
        int N = board[0].size();
		if (i < 0 || i >= M || j < 0 || j >= N || board[i][j] != 'O') {
			return;
		}
		dfs(board, i - 1, j);
		dfs(board, i, j + 1);
		dfs(board, i + 1, j);
		dfs(board, i, j - 1);
	}
};
