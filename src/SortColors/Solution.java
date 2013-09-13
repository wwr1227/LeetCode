package SortColors;

public class Solution {
	public void sortColors(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A == null)
			return;

		int len = A.length;

		int redIndex = 0;
		int blueIndex = len - 1;

		int index = 0;

		while (index <= blueIndex) {
			if (A[index] == 0) {
				swap(A, index, redIndex);
				redIndex++;
				index++;
			} else if (A[index] == 2) {
				swap(A, index, blueIndex);
				blueIndex--;
			} else {
				index++;
			}
		}
	}

	public void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
}

//----------------------------------------------------
public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null||A.length==0)
            return;
        int redIndex=0;
        int blueIndex=A.length-1;
        int i=0;
        while(i<A.length&&redIndex<blueIndex){
            if(A[i]==0){
                if(redIndex<i){
                    swap(A,i,redIndex++);
                    continue;
                }
            }
            if(A[i]==2){
                if(blueIndex>i){
                    swap(A,i,blueIndex--);
                    continue;
                }
            }
            i++;
        }
        
    }
    public void swap(int [] a, int i ,int j){
        int temp =a[i];
        a[i] = a[j];
        a[j]=temp;
        
    }
    
}
