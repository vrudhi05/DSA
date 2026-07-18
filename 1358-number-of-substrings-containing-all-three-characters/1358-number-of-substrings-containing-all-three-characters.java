class Solution {
    public int numberOfSubstrings(String s) {
        int cnt = 0;
        int n = s.length();
        int[] hash = new int[3];
        int left = 0,right = 0;
        while(right < n){
            hash[s.charAt(right)-'a']++;
                while(hash[0] > 0 && hash[1] > 0 && hash[2] > 0){
                    cnt += n - right;
                    hash[s.charAt(left)-'a']--;
                    left++;
                }
                right++;
            }
            return cnt;
        }
    }