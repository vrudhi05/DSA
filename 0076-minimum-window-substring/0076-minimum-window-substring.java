class Solution {
    public String minWindow(String s, String t) {

        int[] freq = new int[128];

        // store frequency of t
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0, count = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            // include character
            if (freq[s.charAt(right)]-- > 0) {
                count--;
            }

            // valid window
            while (count == 0) {

                // apply your formula here
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // remove left character
                if (freq[s.charAt(left)]++ == 0) {
                    count++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE 
                ? "" 
                : s.substring(start, start + minLen);
    }
}