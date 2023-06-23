class Solution {
    static boolean isQueenSafe(boolean board[][],int row,int col){
        //for above row
        for(int i=row;i>=0;i--){
            if(board[i][col]){
                return false;
            }
        }
        //for left diagonal
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]){
                return false;
            }
        }
        //for right diagonal
        for(int i=row,j=col;i>=0 && j<board[row].length;i--,j++){
            if(board[i][j]){
                return false;
            }
        }
        return true;
    }
    static int totalWays(boolean board[][],int currentRow){
        int count=0;
        //termination case
        if(currentRow==board.length){
            return 1;
        }
        for(int col=0;col<board[currentRow].length;col++){
            if(isQueenSafe(board,currentRow,col)){
                board[currentRow][col]=true;
                int result=totalWays(board,currentRow+1);
                count+=result;
                board[currentRow][col]=false;
            }
        }
        return count;
    }
    public int totalNQueens(int n) {
       boolean chessboard[][]=new boolean[n][n];
       return totalWays(chessboard,0);
    }
}
