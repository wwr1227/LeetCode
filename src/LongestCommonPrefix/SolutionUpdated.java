//Time complexity:O(k*n)
public class Solution {
    	public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
		if(strs==null || strs.length==0||strs[0].length()==0)
			return "";
		
        	for (int j = 0; j < strs[0].length(); j++) {
    			for (int i = 1; i < strs.length; i++) {
				if (j >= strs[i].length()) 
					return strs[0].substring(0, strs[i].length());
				if (strs[i].charAt(j) != strs[0].charAt(j))
                    return strs[0].substring(0, j);
			}
		}
		return strs[0];
    	}
}
