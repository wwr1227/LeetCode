public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
      ArrayList<ArrayList<Integer>> res  = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		if(num==null || num.length<3)
			return res;
		
		Arrays.sort(num);
		for(int i=0;i<num.length-2;){
			int target=0-num[i];
			int start=i+1;
			int end=num.length-1;
			while(start<end){
				if(num[start]+num[end]==target){
					item.add(num[i]);
					item.add(num[start]);
					item.add(num[end]);
					res.add(new ArrayList<Integer>(item));
					item.clear();
					while(++start<num.length&&num[start]==num[start-1]);
				}else if(num[start]+num[end]<target)
					start++;
				else
					end--;
			}
            while(++i<num.length-2&&num[i]==num[i-1]);
		}
        return res;
    }
}
