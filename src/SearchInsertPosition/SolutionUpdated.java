public class Solution {
 
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
      if(A==null||A.length==0)
			return -1;
		return binarySearch(A, target, 0, A.length-1, 0);
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
