public class Solution {
    
    HashSet<String> poses = null;
    
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        poses = new HashSet<String>();
        
        if (board.length == 0) {
            return false;
        }
        boolean has = false;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (existCore(board, i, j, word)) {
                    has = true;
                }
            }
        }
        return has;
    }
    
    
    public boolean existCore(char[][] board, int startX, int startY, String word) {
        
        if (word.length() == 0) {
            return true;
        }
        
        if (startX < 0 || startX > board.length - 1
            || startY < 0 || startY > board[0].length - 1) {
                return false;
        }
        
        if (board[startX][startY] != word.charAt(0)) {
            return false;
        } else{ // first char equal
            if (poses.contains(startX + "_" + startY)) {
                return false;
            } else {
                poses.add(startX + "_" + startY);
            }
        }
        
        
        if (       existCore(board, startX, startY + 1, word.substring(1))
                || existCore(board, startX + 1, startY, word.substring(1))
                || existCore(board, startX, startY - 1, word.substring(1))
                || existCore(board, startX - 1, startY, word.substring(1))) {
            return true;
        } else {
            poses.remove(startX + "_" + startY);
        }
        return false;
    }
}
