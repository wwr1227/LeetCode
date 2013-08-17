public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ans= new  ArrayList<ArrayList<Integer>>();
        if(num==null||num.length==0)
            return ans;
        Arrays.sort(num);
        ArrayList<Integer> item = new ArrayList<Integer>();
        combinationSum2Handler(ans, item, num, target, 0);
        return ans;
    }
    
    public void combinationSum2Handler(ArrayList<ArrayList<Integer>> ans, 
    ArrayList<Integer> item,int[] num, int target, int k){
        if(target<0)
            return;
        if(target==0){
            if(!ans.contains(item))
                ans.add(new  ArrayList<Integer>(item));
            return;
        }
        if(k>=num.length)
            return;
        
        combinationSum2Handler(ans, item, num, target,k+1);
        if(num[k]<=target){
            item.add(num[k]);
            combinationSum2Handler(ans, item, num, target-num[k],k+1);
            item.remove(item.size()-1);
        }
    }
}
