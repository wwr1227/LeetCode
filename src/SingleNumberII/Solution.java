//http://stackoverflow.com/questions/7338070/finding-an-element-in-an-array-where-every-element-is-repeated-odd-number-of-tim

public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A.length==1)
        return A[0];
        int ones = 0;  
        int twos = 0;  
        int not_threes=0, x=0;  
        int n=A.length;
        for (int i=0; i<n; ++i) {  
                x =  A[i];  
                twos |= ones & x;  
                ones ^= x;  
                not_threes = ~(ones & twos);  
                ones &= not_threes;  
                twos &= not_threes;  
       }  
    	 return ones;
    }
}
