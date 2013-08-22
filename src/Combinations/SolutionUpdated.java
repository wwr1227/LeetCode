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
       for(int i=begin;i<n.length;i++){
            item.add(n[i]);
            combineHandler(n,i+1,step+1,k,item,nums);
            item.remove(item.size()-1);
       }
    }
}
