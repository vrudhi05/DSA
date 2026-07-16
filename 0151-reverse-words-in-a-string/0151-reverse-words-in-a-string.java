class Solution {
    public String reverseWords(String s) {
        int i = s.length()-1;
        StringBuilder ans = new StringBuilder();
        int j=-1;
        while(i >= 0){
            
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            if(i < 0){break;}
            j = i;
            while(j >= 0 && s.charAt(j) != ' '){
                j--;
            }
            
            ans.append(s.substring(j+1,i+1));
        
            while(j >= 0 && s.charAt(j) == ' '){
                j--;
            }

            if(j >= 0){
                ans.append(' ');
            }
            i = j;
        }
        return ans.toString();
    }
}