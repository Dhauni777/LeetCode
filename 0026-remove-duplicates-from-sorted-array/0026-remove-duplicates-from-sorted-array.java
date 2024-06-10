class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]<nums[j]){
                int temp=nums[j];
                nums[j]=nums[i+1];
                nums[i+1]=temp;
                i++;
            }
        }
        return i+1;
    }
}