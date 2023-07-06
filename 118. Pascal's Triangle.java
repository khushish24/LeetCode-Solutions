class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> finalList=new ArrayList<>();
         for(int i =0;i<numRows;i++){
             List<Integer> list=new ArrayList<>();
             for(int j=0;j<=i;j++){
                 if(j==0||i==j){
                     list.add(1);
                 }else{
                     list.add(j,finalList.get(i-1).get(j-1)+finalList.get(i-1).get(j));
                 }
             }
             finalList.add(list);
         }
         return finalList;
    }
}
