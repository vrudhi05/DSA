class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int cnt = 0;
        StringBuilder str = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                cnt++;
                if(cnt > 1){
                    str.append('(');
                }
            }
            else{
                cnt--;
                if(cnt > 0){
                    str.append(')');
                }
            }
        }
        return str.toString();
    }
}