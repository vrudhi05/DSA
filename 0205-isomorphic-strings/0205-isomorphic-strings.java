class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char first = s.charAt(i);
            char second = t.charAt(i);
            if(!map.containsKey(first)){
                if(!map.containsValue(second)){
                    map.put(first,second);
                }
                else{
                    return false;
                }
            }
            else{
                char mappedChar = map.get(first);
                if(mappedChar != second){
                    return false;
                }
            }
        }
        return true;
    }
}