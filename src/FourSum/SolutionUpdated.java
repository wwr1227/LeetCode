////Time complexity:O(n^3)
public class Solution {
  public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
      ArrayList<ArrayList<Integer>> rl = new ArrayList<ArrayList<Integer>>();
      if(num == null || num.length < 4) return rl;
      HashSet<ArrayList<Integer>> rll = new HashSet<ArrayList<Integer>>();
      Arrays.sort(num);
      for(int i = 0; i < num.length - 3; i++)
          for(int j = i + 1; j < num.length - 2; j++)
              for(int m = j + 1, n = num.length - 1; m < n;)
                  if(num[m] + num[n] == target - num[i] - num[j]){
                      ArrayList<Integer> tmp = new ArrayList<Integer>();
                      tmp.addAll(Arrays.asList(num[i], num[j], num[m++], num[n--]));
                      rll.add(tmp);
                  }
                  else if(num[m] + num[n] < target - num[i] - num[j]) m++;
                  else n--;
      rl.addAll(rll);
      return rl;
  }
}
