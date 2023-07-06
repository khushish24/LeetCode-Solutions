//Approach one:
class Solution {
    int arr[]={};
    public void swap(int first,int second){
        int temp=0;
        temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
    public void sortColors(int[] nums) {
       int low=0;// responsblity to get 0
       int high=nums.length-1; // responsiblity to get 2
       int mid=0;// responsiblity to get 1
       arr=nums;
       while(mid<=high){
           int value=nums[mid];
           switch(value){
               case 0:
               swap(low,mid);
               low++;
               mid++;
               break;
               case 1:
               mid++;
               break;
               case 2:
               swap(mid,high);
               high--;
               break;
           }
       }
    }
}


//Approach two:
class Solution {
    public void sortColors(int[] nums) {
        int countZero=0;
        int countOne=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                countZero++;
            }else if(nums[i]==1){
                countOne++;
            }
        }
        //to fill the array now with zero first
        for(int i=0;i<countZero;i++){
            nums[i]=0;
        }
        //to fill the array now with one now
        for(int i=countZero;i<(countZero+countOne);i++){
            nums[i]=1;
        }
         //to fill the array now with two now
        for(int i=(countOne+countZero);i<nums.length;i++){
            nums[i]=2;
        }
        

    }
}
