class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i=0;i<nums.length;i++){
            if(cnt1 == 0 && candidate2 != nums[i]){
                candidate1 = nums[i];
                cnt1++;
            }
            else if(cnt2 == 0 && candidate1 != nums[i]){
                candidate2 = nums[i];
                cnt2++;
            }
            else if(nums[i] == candidate1){
                cnt1++;
            }
            else if(nums[i] == candidate2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == candidate1){
                count1++;
            }
            if(nums[i] == candidate2){
                count2++;
            }
        }
        int minCount = (nums.length/3)+1;
        if(count1 >= minCount){
            list.add(candidate1);
        }
        if(count2 >= minCount){
            list.add(candidate2);
        }
        return list;
    }
}