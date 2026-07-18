class Solution {
    public int num(char ch){
        switch(ch){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            default:
                return 1000;
        }
    }
    public int romanToInt(String s) {
        int n = s.length();
        int index = 0,sum = 0;
        while(index < n-1){
            if(num(s.charAt(index)) < num(s.charAt(index+1))){
                sum -= num(s.charAt(index));
            }
            else{
                sum += num(s.charAt(index));
            }
            index++;
        }
        sum += num(s.charAt(n-1));
        return sum;
    }
}