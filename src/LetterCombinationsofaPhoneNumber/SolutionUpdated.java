//Time complexity:O(3^n)
public class Solution {
  	static Map<Integer, String> telephone = buildTelephone();
	public ArrayList<String> letterCombinations(String digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> ans = new ArrayList<String>();
		if (digits == null)
			return ans;
		letterCombinationsHelper(digits, 0, "", ans);
		return ans;
	}
	public void letterCombinationsHelper(String digits, int begin, String item, ArrayList<String> ans) {
		if (begin == digits.length()) {
			if (!ans.contains(item))
				ans.add(item);
			return;
		}
		String candidates = telephone.get(Character.getNumericValue(digits.charAt(begin)));
		for (int j = 0; j < candidates.length(); j++) {
			item += String.valueOf(candidates.charAt(j));
			letterCombinationsHelper(digits, begin + 1, item, ans);
			item = item.substring(0, item.length() - 1);
		}
	}

	public static Map<Integer, String> buildTelephone() {
		Map<Integer, String> telephone = new HashMap<Integer, String>();
		telephone.put(2, "abc");
		telephone.put(3, "def");
		telephone.put(4, "ghi");
		telephone.put(5, "jkl");
		telephone.put(6, "mno");
		telephone.put(7, "pqrs");
		telephone.put(8, "tuv");
		telephone.put(9, "wxyz");
		return telephone;
	}

}
