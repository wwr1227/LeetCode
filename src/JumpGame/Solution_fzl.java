//O(n)
public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 0;
        for(int i=0;i<A.length;i++){
            if(i>max)
                return false;
            max=Math.max(max,i+A[i]);
        }
        return true;
    }
}
