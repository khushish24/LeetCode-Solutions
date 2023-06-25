class Solution {
    private void genPerm(String s,List<String> result,StringBuilder output){
        if(s.length()==0){
            result.add(output.toString());
            return;
        }
        char firstChar=s.charAt(0);
        if(safeCon(firstChar)){
            //to include lowercase
            output.append(Character.toLowerCase(firstChar));
            genPerm(s.substring(1),result,output);
            output.deleteCharAt((output.length()-1));
            
            //first,of all check whether firstChar is in lowercase,if yes then it will go inside.
            //to include uppercase
            if(Character.isLowerCase(firstChar)||Character.isUpperCase(firstChar)){
            output.append(Character.toUpperCase(firstChar));
            genPerm(s.substring(1),result,output);
            output.deleteCharAt(output.length()-1);
            }
            
        }else{
            output.append(firstChar);
            //genPerm(s.substring(1),result,output);
        }
    }

    //but to get into recursive step it should be a letter not a numeric value.
    private boolean safeCon(char firstChar){
        int arr[]={0,1,2,3,4,5,6,7,8,9};
        int num=(char)(firstChar+'0');
        for(int i=0;i<arr.length;i++){
            if(num==arr[i]){
                return false;
            }
        }
        return true;
    }
    public List<String> letterCasePermutation(String s) {
        List<String> result=new ArrayList<>();
        StringBuilder output=new StringBuilder();
        genPerm(s,result,output);
        return result;
    }
}
