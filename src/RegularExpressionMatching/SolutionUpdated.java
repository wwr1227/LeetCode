//O(n*m)
/**
    '.' Matches any single character.
	'*' Matches zero or more of the preceding element.
	
	The matching should cover the entire input string (not partial).
	
	The function prototype should be:
	bool isMatch(const char *s, const char *p)
	".*" means repeat '.' 0 or more times
	Some examples:
	isMatch("aa","a") ? false
	isMatch("aa","aa") ? true
	isMatch("aaa","aa") ? false
	isMatch("aa", "a*") ? true
	isMatch("aa", ".*") ? true
	isMatch("ab", ".*") ? true
	isMatch("aab", "c*a*b") ? true
**/
public class Solution {
	public boolean isMatch(String s, String p) {
	// Start typing your Java solution below
	// DO NOT write main() function
	    	if(s==null)
			return true;
		if(p.length()==0)
			return s.length()==0;
		return match(s, p, 0, 0);
	}
	public boolean match(String s, String p, int i, int j){
		if(j == p.length()) 
	    	  	return i == s.length();   
		if(j == p.length() - 1 || p.charAt(j + 1) != '*'){
	  		if(i == s.length()) 
	      			return false;
	  		else
	      			return (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) && match(s, p, ++i, ++j);
		}                               
		while(i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)))  
		    	if (match(s, p, i++, j + 2)) 
		    		    return true;
		return match(s, p, i, j + 2);   
	}
}
