//O(n)
public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
		if(A == null||A.length<=2)
			return 0;
		
		int[] maxFromLeft = new int [A.length];
		int[] maxFromRight = new int [A.length];
		maxFromLeft[0]=A[0];
		for(int i=1;i<A.length;i++){
			maxFromLeft[i] = Math.max(maxFromLeft[i-1],A[i]);
		}
		maxFromRight[A.length-1]=A[A.length-1];
		for(int i=A.length-2;i>=0;i--){
			maxFromRight[i] = Math.max(maxFromRight[i+1],A[i]);
		}
		int ans = 0;
		for(int i=1;i<A.length-1;i++){
			int minHeight = Math.min(maxFromRight[i+1],maxFromLeft[i-1]);
			if(minHeight>A[i])
				ans += minHeight-A[i];
		}
		return ans;        
    }
}
