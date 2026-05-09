class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int right=0,left=0;
        int ans = 0;

        int[] hash = new int[3];

        while(right < n){
            hash[s.charAt(right)-'a']++;

            while(hash[0] >0 
            && hash[1] > 0 
            && hash[2] > 0){
                ans += (n-right);
                hash[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return ans;
    }
}