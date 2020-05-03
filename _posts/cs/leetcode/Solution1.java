class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = null;
        for(int i = 0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    res = new int[]{i,j};                   
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int target = 3;
        int[] res = twoSum(nums,target);
        for(int e:res){
            System.out.println(e);
        }
    }
}