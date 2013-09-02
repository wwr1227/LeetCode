//O(n)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
      
		int[] ans ={0,0};
        	if(numbers==null || numbers.length==0)
			return ans;
		
		int len = numbers.length;
		Map<Integer, Integer> hash = new HashMap<Integer,Integer>();
		for(int i=0;i<len ;i++){
			hash.put(numbers[i],i);
		}
		for(int i=0;i<len ;i++){
			if(hash.containsKey(target-numbers[i])){
				ans[0]=i+1;
				ans[1]=hash.get(target-numbers[i])+1;
				break;
			}
		}
		return ans;
    }
}
