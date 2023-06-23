class Solution {
    final int MAX_SIZE=9;
    private boolean isSafeToPlace(int row,int col,char value){
        //to check for row
        for(int i=0;i<MAX_SIZE;i++){
            if(board[i][col]==value){
                return false;
            }
        }
        //to check for column
        for(int i=0;i<MAX_SIZE;i++){
            if(board[row][i]==value){
                return false;
            }
        }
        //to check for 3*3 sub-grid
        int currentRow=row-row%3;
        int currentCol=col-col%3;
        for(int i=currentRow;i<currentRow+3;i++){
            for(int j=currentCol;j<currentCol+3;j++){
            if(board[i][j]==value){
                return false;
            }
            }
        }
        return true;
    }
    char[][] board;
    private boolean printSudoku(int row,int col){
        if(col==MAX_SIZE){
            row+=1;
            col=0;
        }
        //Termination Case
        if(row==MAX_SIZE){
            return true;
        }
        //case if there is an element present
        if(board[row][col]!='.'){
            return printSudoku(row,col+1);
        }
        //case for printing 1-9 values
        for(int i=1;i<=MAX_SIZE;i++){
            if(isSafeToPlace(row,col,(char)(i+'0'))){
                board[row][col]=(char)(i+'0');
                boolean result=printSudoku(row,col+1);
                if(result){
                    return true;
                }
                board[row][col]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        this.board=board;
        printSudoku(0,0);
    }
}
