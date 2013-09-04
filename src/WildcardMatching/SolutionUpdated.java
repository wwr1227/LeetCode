//0(n*m)
public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
	if(s==null||p==null)
		return false;
	
	int i=0,j=0;
	int backI = -1;
	int backJ = -1;
	while(i<s.length()){
		if(j<p.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')){
			i++;
			j++;
			continue;
		}
		if(j<p.length()&& p.charAt(j)=='*'){
			backI = i;
			backJ = j;
			j++;
			continue;
		}
		if(backJ!=-1){
			i=backI++;
			j=backJ+1;
			continue;
		}
		return false;
	}
	while (j<p.length()&& p.charAt(j) == '*') ++j;
	return (i==s.length()&&j==p.length());
    }
}
