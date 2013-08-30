public class Solution {
	public boolean search(int[] A, int target) {
	// Start typing your Java solution below
	// DO NOT write main() function
		if(A==null||A.length==0)
			return false;
		int start = 0;
		int end = A.length-1;
		while(start<=end){
			int mid = start+(end-start)/2;
			if(A[mid]==target)
				return true;
			if(A[start]<A[mid]){
				if(target<A[mid]&&target>=A[start])
					end = mid-1;
				else
					start = mid+1;
			}else if(A[start]>A[mid]){
				if(A[mid]<target&&target<=A[end])
					start=mid+1;
				else
					end=mid-1;
			}else{
				start++;
			}
		}
		return false;
	}
}
