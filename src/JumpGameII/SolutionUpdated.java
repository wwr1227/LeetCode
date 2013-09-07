//Time complexity:O(n)
public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length<=1)
            	return 0;
	int maxDistance = 0;
	int minStep=0;
	int end=0;
	int begin=0;
	while(end<A.length-1){
	    minStep++;
		for(int i=begin;i<=end;i++)
			maxDistance = Math.max(maxDistance, A[i]+i);
		if(maxDistance<=end)
			return -1;
		begin=end+1;
		end=maxDistance;
	}
	return minStep;
    }
}
