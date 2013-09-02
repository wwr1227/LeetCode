//O(n)
public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null||s.length()==0)
            return 0;
        if(!s.contains(" "))
            return s.length();
        String[] splitStrs = s.split(" ");
        if(splitStrs.length==0)
            return 0;
        else
            return splitStrs[splitStrs.length-1].length();
    }
}
