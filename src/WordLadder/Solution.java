//O(|dict|*wordLen*26)
public class Solution {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Queue<String> queue = new LinkedList<String>();
		Queue<Integer> length = new LinkedList<Integer>();
		queue.add(start);
		length.add(1);
		while (!queue.isEmpty()) {
			String word = queue.poll();
			int len = length.poll();
			if (canChange(word, end))
				return len + 1;
			for (int i = 0; i < word.length(); i++)
				for (char c = 'a'; c <= 'z'; c++) {
					if (word.charAt(i) == c)
						continue;
					char[] arr = word.toCharArray();
					arr[i] = c;
					String str = String.valueOf(arr);
					if (dict.contains(str)) {
						queue.add(str);
						length.add(len + 1);
						dict.remove(str);
					}
				}
		}
		return 0;
	}

	public boolean canChange(String start, String stop) {
		int diff = 0;
		for (int i = 0; i < start.length(); i++)
			if (start.charAt(i) != stop.charAt(i)) {
				if (diff >= 1)
					return false;
				else
					diff++;
			}
		return true;
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
		dict.add("dog");
		dict.add("dot");
		System.out.println(su.ladderLength(start, end, dict));
	}

}
