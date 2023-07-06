class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0; //will point at the starting index
        //loop that will go from 1 to length 
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums[j]){
                j++;
                nums[j]=nums[i];
            }
        }
        //return the index of j with +1(0-indexing)
        return j+1;
    }
}
