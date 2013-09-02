//O(2^n)
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        
        if(S==null||S.length==0)    
            return result;
            
        Arrays.sort(S);
        subsetsHandler(S,0,0,item,result);
        return result;
    }
    public void subsetsHandler(int[] nums,int count,int position,ArrayList<Integer> item,ArrayList<ArrayList<Integer>> ans){
        if(position == nums.length){
            if(!ans.contains(item))
                ans.add(new ArrayList<Integer>(item));
                return;
        }
        subsetsHandler(nums,count+1,position+1,item,ans);
        item.add(nums[count]);
        subsetsHandler(nums,count+1,position+1,item,ans);
        item.remove(item.size()-1);
  
    }
}
