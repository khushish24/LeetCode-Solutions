class Solution {
    static void genBrackets(List<String> result,int n,int open,int close,StringBuilder brackets){
        if(brackets.length()==n*2){
            result.add(brackets.toString());
            System.out.println(result);
            return;
        }
        if(open<n){
            brackets.append("(");
            genBrackets(result,n,open+1,close,brackets);
            brackets.deleteCharAt(brackets.length()-1);
        }
        if(close<open){
            brackets.append(")");
            genBrackets(result,n,open,close+1,brackets);
            brackets.deleteCharAt(brackets.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        StringBuilder brackets=new StringBuilder();
        genBrackets(result,n,0,0,brackets);
        return result;
    }
}
