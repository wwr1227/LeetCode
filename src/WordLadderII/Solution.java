//O(n*wordLen*26)
public class Solution {
	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		// Start typing your Java solution below
		// DO NOT write main() function
		HashSet<String> usedDict = new HashSet<String>();
		LinkedList<ArrayList<String>> resultList = new LinkedList<ArrayList<String>>();
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(start);
		resultList.add(temp);

		while (!resultList.isEmpty()) {
			boolean foundEnd = false;
			int len = resultList.size();
			for (int i = 0; i < len; i++) {
				ArrayList<String> list = resultList.pollFirst();// pop first
																// list
				String from = list.get(list.size() - 1);// get frontier string
				usedDict.add(from);
				char[] arr = from.toCharArray();
				for (int j = 0; j < arr.length; j++) {
					char base = arr[j];
					for (char c = 'a'; c < 'z'; c++) {
						if (c == base)
							continue;
						arr[j] = c;
						String s = new String(arr);
						if (dict.contains(s) && !usedDict.contains(s)) {
							if (s.equals(end))
								foundEnd = true;
							ArrayList<String> newList = new ArrayList<String>(
									list);
							newList.add(s);
							resultList.add(newList);
							System.out.println(from + ":" + newList);
						}
					}
					arr[j] = base;
				}
			}
			if (foundEnd) {
				ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
				for (ArrayList<String> list : resultList) {
					if (list.get(list.size() - 1).equals(end))
						res.add(list);
				}
				return res;
			}
		}
		return new ArrayList<ArrayList<String>>();
	}
}
