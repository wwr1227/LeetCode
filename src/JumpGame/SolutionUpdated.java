//Time complexity:O(n^2)
public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length<=1)
    		return true;
	int maxDistance = 0;
	int end=0;
	int begin=0;
	while(end<A.length-1){
		for(int i=begin;i<=end;i++)
			maxDistance = Math.max(maxDistance, A[i]+i);
		if(maxDistance<=end)
			return false;
		begin=end+1;
		end=maxDistance;
	}
	return true;
    }
}
