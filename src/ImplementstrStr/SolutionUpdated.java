public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(haystack==null || needle==null)
            return null;
        if(needle.length()==0)
            return haystack; 
  	
		for(int i=0;i<haystack.length()-needle.length()+1;i++){
			int needleIndex=0;
			int haystackIndex=0;
			while(haystack.charAt(i+haystackIndex)==needle.charAt(needleIndex)){
				needleIndex++;
				haystackIndex++;
				if(needleIndex==needle.length())
					return haystack.substring(i);
			}
		}
		return null;
    }
}
