public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length<1)
      		return 0;
	int index=-1;
	for(int i=0;i<A.length;i++){
		if(A[i]!=elem)
			A[++index]=A[i];
	}
	return index+1;
    }
}
