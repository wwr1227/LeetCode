//O(logN)
public class Solution {
    	public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        	int[] ans={-1,-1};
      		if(A==null || A.length==0)
			return ans;
		int first = binarySearch(A, target,0, A.length-1, 0);
		if(first<0 || first>A.length-1 || A[first]!=target)
			return ans;
		ans[0] = first;
		ans[1] = binarySearch(A, target,0, A.length-1, 1);
		return ans;
    	}
	public int binarySearch(int[]A, int target, int left, int right, int boundFlag){
		if(boundFlag==0){
			while(left<=right){
				int mid = left+(right-left)/2;
				if(target<=A[mid])
					right=mid-1;
				else
					left=mid+1;
			}
			return left;
		}else if(boundFlag==1){
			while(left<=right){
				int mid = left+(right-left)/2;
				if(target<A[mid])
					right=mid-1;
				else
					left=mid+1;
			}
			return right;
		}
        	return -1;
	}
}
