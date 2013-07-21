package Leetcode; 

/*	word search:
	Given a 2D board and a word, find if the word exists in the grid.

	The word can be constructed from letters of sequentially adjacent cell, 
	where "adjacent" cells are those horizontally or vertically neighboring. 
	The same letter cell may not be used more than once.

	For example,
	Given board =
	[
	  ["ABCE"],
	  ["SFCS"],
	  ["ADEE"]
	]
	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.
	

*/

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] wordChars = word.toCharArray(); 
        boolean[][] flag = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == wordChars[0]){
                    if (wordChecker(board, wordChars, 0, j, i, flag)) 
                        return true;
                }
            }
        }
        return false;        
    }
    
     public static boolean wordChecker(char[][] board, char[] input, int index, int x, int y, boolean[][] flag) {
        if(index == input.length) return true;
        int xSize = board[0].length;
        int ySize = board.length;
        if(y < 0 || x < 0 || y >= ySize || x >= xSize) return false; 
        if(flag[y][x] || board[y][x] != input[index] ) return false;
        
        flag[y][x] = true;

        if(wordChecker(board, input, index+1, x, y-1, flag)) {
            return true;
        }
        if(wordChecker(board, input, index+1, x, y+1, flag)) {
            return true;

        }
        if(wordChecker(board, input, index+1, x-1, y, flag)) {
            return true;
            
        }
        if(wordChecker(board, input, index+1, x+1, y, flag)) {
            return true;
        }
        
        flag[y][x] = false;
        
        return false;
    }
}
