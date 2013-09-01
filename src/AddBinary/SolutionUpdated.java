//Time complexity:O(n)
public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuffer ans = new StringBuffer();
	int carry = 0;
	int aIndex=a.length()-1;
	int bIndex=b.length()-1;
	while(aIndex>=0&&bIndex>=0){
		int aValue = Character.getNumericValue(a.charAt(aIndex));
		int bValue = Character.getNumericValue(b.charAt(bIndex));
		int sum = aValue+bValue+carry;
		ans.append(sum%2);
		carry = sum/2;
		aIndex--;
		bIndex--;
	}
	while(aIndex>=0){
		int aValue = Character.getNumericValue(a.charAt(aIndex));
		int sum = aValue+carry;
		ans.append(sum%2);
		carry = sum/2;
		aIndex--;
	}
	while(bIndex>=0){
		int bValue = Character.getNumericValue(b.charAt(bIndex));
		int sum = bValue+carry;
		ans.append(sum%2);
		carry = sum/2;
		bIndex--;
	}
	while(carry!=0){
		ans.append(carry%2);
		carry = carry/2;
	}
	return ans.reverse().toString();
    }
}
