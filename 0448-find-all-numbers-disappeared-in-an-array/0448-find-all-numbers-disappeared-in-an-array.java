class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        Set<Integer> map = new HashSet<>();
        for(int num : nums){
            if(!map.contains(num)){
               map.add(num);
            }
        }
        for(int i=1;i<=n;i++){
            if(!map.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}