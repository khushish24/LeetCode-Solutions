//Approach-1
class Solution {
    private ArrayList<String> permute(String num){
        //base case
        if(num.length()==0){
            ArrayList<String> list= new ArrayList<>();
            list.add("");
            return list;
        }
        ArrayList<String> list=permute(num.substring(1));
        char firstChar=num.charAt(0);
        ArrayList<String> result=new ArrayList<>();
        for(String s:list){
            for(int i=0;i<=s.length();i++){
                StringBuilder sb=new StringBuilder(s);
                sb.insert(i,firstChar);
                result.add(sb.toString());
            }
        }
        return result;
    }
    public String getPermutation(int n, int k) {
        String num="";
        for(int i=1;i<=n;i++){
        num+=Integer.toString(i);
        }
        ArrayList<String> result=permute(num);
        Collections.sort(result);
        String s=result.get(k-1);
        return s;
    }
}

//Approach-2
