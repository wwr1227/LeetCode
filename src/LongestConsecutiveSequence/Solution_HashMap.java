public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num==null||num.length==0)
            return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max=1;
		for (int i = 0; i < num.length; i++) {
			if(map.containsKey(num[i]))
                continue;
            map.put(num[i], 1);
			if(map.containsKey(num[i]-1))
                max = Math.max(max, merge(map, num[i]-1,num[i]));
            if(map.containsKey(num[i]+1))
                max = Math.max(max, merge(map,num[i], num[i]+1));
		}
        return max;
    }
    public int merge(Map<Integer, Integer> map, int left, int right){
        int lower=left-map.get(left)+1;
        int upper=right+map.get(right)-1;
        int len=upper-lower+1;
        map.put(lower,len);
        map.put(upper,len);
        return len;
    }
}
