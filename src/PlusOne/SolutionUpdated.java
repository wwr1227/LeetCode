public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(digits==null || digits.length<=0)
			return digits;
		int carry = 1;
		int[] ans = new int[digits.length+1];
		for(int i=digits.length-1;i>=0;i--){
			ans[i+1]=(digits[i]+carry)%10;
			carry=(digits[i]+carry)/10;
		}
		if(carry!=0){
			ans[0]=carry;
			return ans;        
		}else{
			int[] dummy = new int[digits.length];
			for(int i=0;i<digits.length;i++)
				dummy[i]=ans[i+1];
			return dummy;
		}
    }
}
