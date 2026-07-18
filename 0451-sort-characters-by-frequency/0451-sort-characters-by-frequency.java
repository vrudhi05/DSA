class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        //map the characters to frequency
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        ArrayList<Character>[] bucket = new ArrayList[n+1];
        //filling the freq buckets with chars
        for(char ch : map.keySet()){
            int freq = map.get(ch);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(ch);
        }

        StringBuilder ans = new StringBuilder();
        for(int i=n;i>=1;i--){
            if(bucket[i] == null){
                continue;
            }
            for(char ch : bucket[i]){
                for(int j=0;j<i;j++){
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}