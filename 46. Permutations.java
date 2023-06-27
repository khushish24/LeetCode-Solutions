class Solution {
    private void getPermutations(List<List<Integer>> result,List<Integer> list,int[] nums,boolean []con){
        if(list.size()==nums.length){
            result.add(new ArrayList(list));
            return ;
        }
        //to traverse the array,to eventually add the possiblity of starting with any element of nums
        for(int i=0;i<nums.length;i++){
            if(!con[i]){
                con[i]=true;
                list.add(nums[i]);
                getPermutations(result,list,nums,con);
                con[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        //to meet the condition,whether the element should be added in the list or not.
        boolean []con=new boolean[nums.length];
        getPermutations(result,list,nums,con);
        return result;
    }
}
