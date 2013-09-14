//O(C(k,n))
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> nums = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        if(n<=0)
            return nums;
        int [] numbers = new int [n];
        for(int i=0;i<n;i++)
            numbers[i]=i+1;
        combineHandler(numbers,0,0,k,item,nums);
        return nums;
    }
    public void combineHandler(int[]n, int begin, int step, int k, ArrayList<Integer> item,ArrayList<ArrayList<Integer>> nums){
       if(step==k){
         if(!nums.contains(item))
                nums.add(new ArrayList<Integer>(item));
                return;
        }
        if(begin>=n.length) return;
        item.add(n[begin]);
        combineHandler(n,begin+1,step+1,k,item,nums);
        item.remove(item.size()-1);
        combineHandler(n,begin+1,step,k,item,nums);
    }
}
//=================================================================================================
public class Solution {
   public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (k <= 0 || k > n)
			return ans;
		ArrayList<Integer> item = new ArrayList<Integer>();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = i + 1;
		dfs(nums, n, k, 0, ans, item);
		return ans;
	}

	public void dfs(int[] nums, int n, int k, int start,
			ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> item) {
		if (item.size() == k) {
			if (ans.contains(item))
				return;
			ans.add(new ArrayList<Integer>(item));
			return;
		}
		if (start >= n)
			return;
		dfs(nums, n, k, start + 1, ans, item);
		item.add(nums[start]);
		dfs(nums, n, k, start + 1, ans, item);
		item.remove(item.size() - 1);
	}

}
