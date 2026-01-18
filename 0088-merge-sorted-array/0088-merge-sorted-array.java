class Solution {
    void swap(int[] nums1,int[] nums2,int i,int j){
        int temp=nums1[i];
        nums1[i]=nums2[j];
        nums2[j]=temp;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left=0;
        int right=0;
        while(left<nums1.length && right<nums2.length){
            if(nums1[left]==0){
                swap(nums1,nums2,left,right);
                right++;
            }
            left++;
        }
        Arrays.sort(nums1);
    }
}