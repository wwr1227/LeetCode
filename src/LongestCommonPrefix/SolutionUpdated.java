public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
  	if(strs==null || strs.length==0)
			return "";
		
	    String prefix = strs[0];
		for(int i=1;i<strs.length;i++){
			for(int j=0;j<prefix.length();j++){
				if(j==strs[i].length() || prefix.charAt(j)!=strs[i].charAt(j)){
					if(j==0) return "";
					prefix = prefix.substring(0,j);
				}
			}
		}
        return prefix;
    }
}
