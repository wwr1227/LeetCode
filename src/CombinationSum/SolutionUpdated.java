public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    // Start typing your Java solution below
    // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if(candidates==null || candidates.length==0)
            return ans;
        Arrays.sort(candidates);
        ArrayList<Integer> item = new ArrayList<Integer>();
        combinationSumHandler(ans, item, candidates, target, 0);
        return ans;
    }
    public void  combinationSumHandler( ArrayList<ArrayList<Integer>> ans, ArrayList<Integer>  item,int[] candidates, int target, int k){
        if (target < 0) return;
        
        if(target==0){
            ans.add(new ArrayList<Integer>(item));
            return;
        }
        if (k >= candidates.length) return;
        
        combinationSumHandler(ans, item,candidates,target,k+1);
        int value = candidates[k];
        for(int i=1;i*value<=target;i++){
            for(int j=0;j<i;j++)
                item.add(value);
            combinationSumHandler(ans, item,candidates,target-i*value,k+1);
            for(int j=0;j<i;j++)
                item.remove(item.size() - 1);
        }
    }
}
