class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] output=new int[2];
        HashMap<Integer,Integer> hash= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hash.get(nums[i])==null){
                int index=target-nums[i];
                hash.put(index,i);
            }else{
                int firstIndex=hash.get(nums[i]);
                int secondIndex=i;
                output[0]=firstIndex;
                output[1]=secondIndex;
            }
        }
        return output;
    }
}
