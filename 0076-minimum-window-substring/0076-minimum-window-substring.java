class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if(t.length() > n){
            return "";
        }

        int i=0,j=0,start=0;
        int minWindowSize = Integer.MAX_VALUE;
        int[] freq = new int[128];
        int reqCount = t.length();

        for(char ch : t.toCharArray()){
            freq[ch]++; //store the chars of t
        }

        while(j < n){
            char ch = s.charAt(j); //keep storing the chars of s
            if(freq[ch] > 0){
                reqCount--; //decrease the count when the freq of char is > 0
            }
            freq[ch]--; //either decrease the count of already existing or decrease the count of chars which are not present in t, as we don't need them

            while(reqCount == 0){ //shrink the window
                if(minWindowSize > (j-i+1)){
                    minWindowSize = j-i+1;
                    start=i;
                }

                freq[s.charAt(i)]++;
                if(freq[s.charAt(i)] > 0){
                    reqCount++;
                }
                i++;
            }
            j++;
        }
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start,start+minWindowSize); //start, start+till the minwindowsize
    }
}