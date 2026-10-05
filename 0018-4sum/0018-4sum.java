class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i=0;i<=n-4;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                    continue;
                }
            for(int j=i+1;j<=n-3;j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int low=j+1,high=n-1;
                while(low < high){
                    long sum = (long)nums[i]+nums[j]+nums[low]+nums[high];
                    if((sum < (long)target)){
                    low++;
                }
                else if(sum == (long)target){
                    List<Integer> sub = new ArrayList<>();
                    sub.addAll(List.of(
                        nums[i],nums[j],nums[low],nums[high]
                    ));
                    list.add(sub);
                    while(low < high && nums[low] == nums[low+1]){
                        low++;
                    }
                    while(low < high && nums[high] == nums[high-1]){
                        high--;
                    }
                    low++;
                    high--;
                }
                else{
                    high--;
                }
                }
            }
        }
        return list;
    }
}