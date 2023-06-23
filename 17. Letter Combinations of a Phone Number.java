class Solution {
    //maintained a array of keys at specific position to map with digits easily
    String phoneKeys[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> letterCombo(String digits){
        if(digits.length()==0){
            List<String> l=new ArrayList<>();
            l.add("");
            return l;
        }
        char firstDigit=digits.charAt(0);
        //to typecast it in
        int num=firstDigit-'0';
        String phoneKey=phoneKeys[num];
        List<String> finalList=new ArrayList<>();
        for(int i=0;i<phoneKey.length();i++){
            List<String> l=letterCombo(digits.substring(1));
            for(String s:l){
                finalList.add(phoneKey.charAt(i)+s);
            }
        }
        return finalList;
    }
    public List<String> letterCombinations(String digits) {
        //to easilt deal with the case of empty string.
        if(digits.length()==0){
            List<String> l=new ArrayList<>();
            return l;
        }
        return letterCombo(digits);
    }
}
