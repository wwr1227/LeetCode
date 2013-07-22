package WordLadderII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		String start = "hot";
		String end = "dog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("cog");
		dict.add("dog");
		dict.add("tot");
		dict.add("hog");
		dict.add("hop");
		dict.add("pot");
		dict.add("dot");
		System.out.println(su.findLadders(start, end, dict));
	}
	/**
	 * 
	 "hot", "dog", ["hot","cog","dog","tot","hog","hop","pot","dot"]
	 * [["hot","dot","pot","tot","hog","hop","dog"]]
	 * [["hot","dot","dog"],["hot","hog","dog"]]
	 * 
	 * "hot", "dog", ["hot","dog","cog","pot","dot"] [["hot","dot","pot","dog"]]
	 * [["hot","dot","dog"]]
	 * 
	 * "hit", "cog", ["hot","cog","dot","dog","hit","lot","log"]
	 * [["hit","hot","dot","lot","hit","dog","log","cog"]]
	 * [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
	 * 
	 * "hit", "cog", ["hot","hit","cog","dot","dog"]
	 * [["hit","hot","dot","hit","dog","cog"]] [["hit","hot","dot","dog","cog"]]
	 * 
	 * "red", "tax", ["ted","tex","red","tax","tad","den","rex","pee"]
	 * [["red","ted","rex","red","tad","tex","tax"]]
	 * [["red","ted","tad","tax"],[
	 * "red","ted","tex","tax"],["red","rex","tex","tax"]]
	 * 
	 * "lost", "cost", ["most","fist","lost","cost","fish"] [["lost","cost"]]
	 * [["lost","cost"]]
	 * 
	 * "lost", "miss", ["most","mist","miss","lost","fist","fish"]
	 * [["lost","most","lost","mist","miss"]] [["lost","most","mist","miss"]]
	 */
}
