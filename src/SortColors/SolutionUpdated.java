public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(A==null || A.length<=1)
			return;
		int red = 0;
		int blue = A.length-1;
		int i=0;
		boolean isSwap = false;
		while(i<A.length&&red<blue){
			isSwap = false;
			if(A[i]==0){
				if(red<i){
					swap(A,i,red);
					red++;
					isSwap = true;
				}
			}else if(A[i]==2){
				if(blue>i){
					swap(A,i,blue);
					blue--;
					isSwap = true;
				}
			}
			if(!isSwap)
				i++;
		}
    }
	public void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i]=array[j];
		array[j]=temp;
		
	}
}
