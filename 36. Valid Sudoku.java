class Solution {
    private boolean safeToPlace(char[][] board,int row,int col,char value){
        for(int i=0;i<board.length;i++){
            if(board[i][col]==value){
                return false;
            }
        }
        for(int i=0;i<board.length;i++){
            if(board[row][i]==value){
                return false;
            }
        }
        int startRow=row-row%3;
        int startCol=col-col%3;
        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                if(board[i][j]==value){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board,int row,int col){
        if(col==board.length){
            row+=1;
            col=0;
        }
        if(row==board.length){
            return true;
        }
        if(board[row][col]=='.'){
            return isValid(board,row,col+1);
        }else{
            char firstChar=board[row][col];
            board[row][col]='0';
            if(safeToPlace(board,row,col,firstChar)){
                boolean result=isValid(board,row,col+1);
                if(result){
                    return true;
                }
            }
        }
        return false;

    }
    public boolean isValidSudoku(char[][] board) {
         if(board.length!=9||board[0].length!=9){
             return false;
         }
         return isValid(board,0,0);
        
    }
}
