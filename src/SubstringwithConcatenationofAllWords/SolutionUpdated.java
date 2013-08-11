public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
      ArrayList<Integer> ans = new ArrayList<Integer>();
		if(S==null || S.length()==0 || L.length==0)
			return ans;
		int wordLen =L[0].length();
		if(S.length()<L.length*wordLen)
			return ans;
		Map<String, Integer> words = new HashMap<String, Integer>();
		for(int i=0;i<L.length;i++){
			if(words.containsKey(L[i]))
				words.put(L[i],words.get(L[i])+1);
			else
				words.put(L[i],1);
		}
		for (int i = 0; i < S.length() - L.length*wordLen + 1; i++) {
			int j = 0;
			HashMap<String, Integer> dic = new HashMap<String, Integer>(words);
			String subString = S.substring(i, i + L.length*wordLen);
			while (j <  L.length) {
				String compare = subString.substring(j*wordLen, (j+1)*wordLen);
				if (dic.containsKey(compare)) {
					if (dic.get(compare) == 1)
						dic.remove(compare);
					else
						dic.put(compare, dic.get(compare) - 1);
					if (dic.isEmpty()) {
						ans.add(i);
						break;
					}
				} else {
					break;
				}
				j++;
			}
		}
		return ans;
	}
}
