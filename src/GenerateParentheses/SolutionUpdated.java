//Time complexity:O(n)
public class Solution {
	public ArrayList<String> generateParenthesis(int n) {
	// Start typing your Java solution below
	// DO NOT write main() function
		ArrayList<String> ans = new ArrayList<String>();
	    	String item = "";
		if(n<=0)
			return ans;
		dfs(ans,0,0,n,item);
		return ans;		
	}
	public void dfs(ArrayList<String> ans, int left, int right, int n, String pare){
		if (left < right) return;
		if(left==right && left==n){
			ans.add(pare);
			return;
		}
		if(left<n){
			pare+="(";
			dfs(ans, left+1,right, n, pare);
			pare=pare.substring(0,pare.length()-1);
		}
		if(right<left){
			pare+=")";
			dfs(ans, left,right+1, n, pare);
			pare=pare.substring(0,pare.length()-1);
		}	
	}
}
