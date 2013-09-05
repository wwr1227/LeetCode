//O(n)
public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
		if(num==null || num.length<=1)
			return;
		int len = num.length;
		int cur = num.length-1;
		
		while(cur>0 && num[cur-1]>=num[cur])
			cur--;
		
		reverse(num, cur, len-1);
		
		if(cur>0){
			int next=cur;
			cur-=1;
			while(num[next] <= num[cur])
				next++;
			swap(num, cur, next);
		}        
    }
	public void reverse(int [] num, int i, int j){
		while(i<j)
			swap(num,i++,j--);
	}
	public void swap(int [] num, int i, int j){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
