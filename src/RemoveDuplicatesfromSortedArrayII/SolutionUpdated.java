public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(A.length<=2)
			return A.length;
		
		int len = A.length;
		int count = 1;
		int post = 0;
		for(int i=1;i<len;i++){
			if(A[post] == A[i]){
				if(count<2){
					count++;
					A[++post] = A[i];
				}
			}else{
				count=1;
				A[++post] = A[i];
			}
		}
        return post+1;
    }
}
