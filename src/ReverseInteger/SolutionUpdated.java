// O(1)
public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean isPos = true;
        if(x<0){
            isPos=false;
            if(x==Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            x=0-x;
        }
        int reverseX=0;
        while(x!=0){
            reverseX=reverseX*10+x%10;
            x=x/10;
        }
        if(!isPos)
            return 0-reverseX;
        else
            return reverseX;
    }
}
