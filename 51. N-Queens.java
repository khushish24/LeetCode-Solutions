class Sol{
    boolean board [][];
    List<List<String>> finalList=new ArrayList<List<String>>();
    boolean isSafe(int row,int col){
        for(int i=row;i>=0;i--){
            if(board[i][col]){
                return false;
            }
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]){
                return false;
            }
        }
        for(int i=row,j=col;i>=0 && j<board[row].length;i--,j++){
            if(board[i][j]){
                return false;
            }
        }
        return true;
    }
    int waysQueen(int currentRow){
        int count=0;
            if(currentRow==board.length){
                List<String> l=fillList();
                finalList.add(l);
                return 1;
            }

        for(int col=0;col<board[currentRow].length;col++){
            if(isSafe(currentRow,col)){
                board[currentRow][col]=true;
                int result = waysQueen(currentRow+1);
                count+=result;
                board[currentRow][col]=false;
            }
        }
        return count;
    }
    List<String> fillList(){
        List<String> list=new ArrayList<>();
        String dots="";
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]){
                    dots+="Q";
                }else{
                    dots+=".";
                }
            }
            list.add(dots);
            dots="";
        }
        return list;
    }
}
class Solution {
    public List<List<String>> solveNQueens(int n) {
        Sol obj=new Sol();
        obj.board=new boolean[n][n];
        if(n==1){
            List<List<String>> finalList=new ArrayList<List<String>>();
            String s="Q";
            List<String> list=new ArrayList<>();
            list.add(s);
            finalList.add(list);
        }
        obj.waysQueen(0);
        return obj.finalList;
    }
}
